import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJobDetail extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		//每两秒打印一次
		System.out.println("hello quarzt :"+System.currentTimeMillis());
	}
	
	
}
