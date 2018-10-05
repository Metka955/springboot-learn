package com.metka.util;

import java.util.concurrent.CountDownLatch;

import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.util.HttpClientUtils;


/**
 * 并发测试类
 * @author Metka
 *
 */
public class ConcurrencyTestUtil {
	
	private RestTemplate template=new RestTemplate();
	private ConcurrencyTestUtil() {}
	
	private static class ConcurrencyTestUtilInstance {
		private static final ConcurrencyTestUtil instance=new ConcurrencyTestUtil();
	}
	
	public static ConcurrencyTestUtil getInstance() {
		return ConcurrencyTestUtilInstance.instance;
	}
	
	public void startConcurrencyTest(String url,int currencyCount) {
		CountDownLatch cdl=new CountDownLatch(currencyCount);
		for (int i = 0; i < currencyCount; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						cdl.await(); //等待
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					template.getForEntity(url, String.class);
					
				}
			}).start();
			cdl.countDown();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConcurrencyTestUtil c=ConcurrencyTestUtil.getInstance();
		c.startConcurrencyTest("localhost:8080/test", 200);
	}
}
