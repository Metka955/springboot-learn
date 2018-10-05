package com.metka.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Documented
public @interface Valid {

	/**
	 * 参数名称 role.user.name
	 * 
	 * @return
	 */
	String name();

	/**
	 * 是否必须
	 * 
	 * @return
	 */
	boolean required() default false;

	/**
	 * 最小值
	 * 
	 * @return
	 */
	double minVaule() default Double.MIN_VALUE;

	/**
	 * 最大值
	 * 
	 * @return
	 */
	double maxValue() default Double.MAX_VALUE; 

	/**
	 * 指定字符串长度
	 * 
	 * @return
	 */
	long length() default -1;

	/**
	 * 最小长度
	 * 
	 * @return
	 */
	long minLength() default -1;

	/**
	 * 最大长度
	 * 
	 * @return
	 */
	long maxLength() default -1;
	
	
	/**
	 * 正则匹配
	 * @return
	 */
	String regex() default "";
}
