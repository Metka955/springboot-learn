package com.metka.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.metka.annotation.Valid;
import com.metka.annotation.Valids;

@Component
@Aspect
public class ArgumentValid {

	@Around(value = "@annotation(com.metka.annotation.Valids)")
	public Object valid(ProceedingJoinPoint joinPoint) throws Throwable {
		// User getUser(String username,String password, User user)

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		// 参数和参数名绑定放入map中
		Map<String, Object> map = bindingArgsAndValue(joinPoint, method);

		// 获取注解valids 完成参数校验
		Valids valids = method.getAnnotation(Valids.class);
		valid(map, valids);

		return joinPoint.proceed();
	}

	private void valid(Map<String, Object> map, Valids valids) throws Exception {
		// TODO Auto-generated method stub
		for(Valid valid:valids.valid()) {
			
			//参数为user
			//name为user.username  要校验的值为 user.getUserName
			
			String name=valid.name();
			String strs[]=name.split("\\.");
			String arg=strs[0];  //参数名
			Object argObj=map.get(arg); //参数的对象 User
			for (int i = 1; i < strs.length; i++) {
				Method m=argObj.getClass().getMethod("get"+StringUtils.capitalize(strs[i]));
				argObj=m.invoke(argObj);
			}
			//待校验的对象
			Object objValid=argObj;
			
			//如果某些属性不等于默认值 则需校验
			if(Double.MAX_VALUE!=valid.maxValue()) {
				
				Number n= (Number) objValid;
				if(n.doubleValue()>valid.maxValue()) {
					throw new RuntimeException("参数大于："+valid.maxValue());
				}
			}
			if(Double.MIN_VALUE!=valid.minVaule()) {
				
			}
			if(valid.maxLength()!=-1) {
				
			}
			if(valid.minLength()!=-1) {
				
			}
			if(valid.regex().equals("")) {
				
			}
			
			if(valid.length()!=-1) {
				
			}
			
			if(valid.required()) {
				
			}
		}
	}

	private Map<String, Object> bindingArgsAndValue(ProceedingJoinPoint joinPoint, Method method) {

		// 获取参数名和映射的值 放入map中 key=参数名 value=值
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取参数值
		Object args[] = joinPoint.getArgs();

		Parameter parameters[] = method.getParameters();
		
		for (int i = 0; i < parameters.length; i++) {
			map.put(parameters[i].getName(), args[i]);
		}

		return map;
	}
}
