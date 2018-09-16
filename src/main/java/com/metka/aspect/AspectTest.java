package com.metka.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest{

	@Pointcut("execution(public *  com.metka.service.impl.TestAspectImpl.test(..))")
	public void testPointCut(){}

	@Before(value="testPointCut()")
	public void funBefore(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		
		System.out.println("funBefore");
	}

	@After(value="testPointCut()")
	public void funAfter() {
		System.out.println("funAfter");
	}

	@AfterReturning(value="testPointCut()")
	public String  funAfterReturning() {
		System.out.println("funAfterReturning");
		return null;
	}

	@AfterThrowing(value="testPointCut()")
	public String funThrowing() {
		System.out.println("funThrowing");
		return null;
	}

}
