package com.metka.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.metka.quarzt.MyFirstJob;
import com.metka.util.QuartzUtil;

/**
 * 
 */
@Component
@Order(value = 9)
public class QuartzConfig implements CommandLineRunner {
	@Value("${spring.datasource.driverClassName}")
	private String				driver;
	
	@Value("${spring.datasource.url}")
	private String				url;
	
	@Value("${spring.datasource.username}")
	private String				username;
	
	@Value("${spring.datasource.password}")
	private String				password;
	
	@Resource
	private JobFactory			jobFactory;
	@Resource
	private ApplicationContext	applicationContext;
	@Resource
	private DataSource dataSource;
	
	private Properties quartzProperties() {
		Properties prop = new Properties();
		prop.put("quartz.scheduler.instanceName", "ServerScheduler");
		prop.put("org.quartz.scheduler.instanceId", "AUTO");
		prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
		prop.put("org.quartz.scheduler.jmx.export", "true");
		
		
		prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
		prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
		prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
		//prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
		
		prop.put("org.quartz.jobStore.useProperties", "false");
		prop.put("org.quartz.jobStore.dataSource", "myDS");
		prop.put("org.quartz.dataSource.myDS.connectionProvider.class", "com.metka.config.DruidConnectionProvider");

		
		prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
		prop.put("org.quartz.jobStore.isClustered", "true");
		prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		prop.put("org.quartz.threadPool.threadCount", "5");
		
		prop.put("org.quartz.dataSource.myDS.driver", driver);
		prop.put("org.quartz.dataSource.myDS.URL", url);
		prop.put("org.quartz.dataSource.myDS.user", username);
		prop.put("org.quartz.dataSource.myDS.password", password);
		prop.put("org.quartz.dataSource.myDS.maxConnection", "10");
		return prop;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		JobDetailFactoryBean myFirstJob = QuartzUtil.createJobDetail(MyFirstJob.class, "group", "myFirstJob");
		myFirstJob.setBeanName("myFirstJob");
		myFirstJob.afterPropertiesSet();
		
		
		CronTriggerFactoryBean myFirstTrigger = QuartzUtil.dialogStatusTrigger(myFirstJob.getObject(), "* * * * * ? *");
		myFirstTrigger.setBeanName("myFirstTrigger");
		myFirstTrigger.afterPropertiesSet();
		
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setJobFactory(jobFactory);
		factory.setOverwriteExistingJobs(true);
		factory.setStartupDelay(10);
		factory.setQuartzProperties(quartzProperties());
		
		factory.setDataSource(dataSource);
		factory.setAutoStartup(true);
		factory.setApplicationContext(applicationContext);
		factory.setTriggers(myFirstTrigger.getObject());// 增加定时器 需要在此处增加
		factory.setBeanName("schedulerFactoryBean");
		factory.afterPropertiesSet();
		//factory.start();
	}
}