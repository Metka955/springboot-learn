package com.metka.util;

import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

public class QuartzUtil {
    /**
     * 创建触发器工厂
     * @param jobDetail
     * @param cronExpression
     * @return
     */
    public static CronTriggerFactoryBean dialogStatusTrigger(JobDetail jobDetail, String cronExpression) {  
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();  
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression (cronExpression);
        return factoryBean;  
    } 
    
    /**
     * 创建job工厂
     * @param jobClass
     * @param groupName
     * @param targetObject
     * @return
     */
    public static JobDetailFactoryBean createJobDetail(Class<? extends Job> jobClass, String groupName, String targetObject) {  
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();  
        factoryBean.setJobClass(jobClass);  
        factoryBean.setDurability(true);  
        factoryBean.setRequestsRecovery(true);
        factoryBean.setGroup(groupName);
        Map<String, String> map = new HashMap<>();
        map.put("targetObject", targetObject);
        map.put("targetMethod", "execute");
        factoryBean.setJobDataAsMap(map);
        return factoryBean;  
    }  
}
