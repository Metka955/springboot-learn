package com.metka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

//注意：使用.yml时，属性名的值和冒号中间必须有空格，如name: Isea533正确，name:Isea533就是错的。
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "redis")
public class RedisConfig {
	private int		port;
	
	private int		maxIdle;
	
	private int		maxTotal;
	
	private boolean	testOnBorrow;
	
	private String	password;
	
	private int		dataBase;
	
	private String	host;
	
	@Bean
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxIdle(maxIdle);
		jpc.setMaxTotal(maxTotal);
		jpc.setTestOnBorrow(testOnBorrow);
		return jpc;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory jcf = new JedisConnectionFactory(
				jedisPoolConfig());
		jcf.setPort(port);
		jcf.setDatabase(dataBase);
		jcf.setHostName(host);
		jcf.setPassword(password);
		return jcf;
	}
	
	@Bean
	public RedisTemplate redisTemplate(){
		RedisTemplate rt = new RedisTemplate();
		rt.setConnectionFactory(jedisConnectionFactory());
		return rt;
		
	}
	
	public Integer getPort(){
		return port;
	}
	
	public void setPort(Integer port){
		this.port = port;
	}
	
	public int getMaxIdle(){
		return maxIdle;
	}
	
	public void setMaxIdle(int maxIdle){
		this.maxIdle = maxIdle;
	}
	
	public int getMaxTotal(){
		return maxTotal;
	}
	
	public void setMaxTotal(int maxTotal){
		this.maxTotal = maxTotal;
	}
	
	public Boolean getTestOnBorrow(){
		return testOnBorrow;
	}
	
	public void setTestOnBorrow(Boolean testOnBorrow){
		this.testOnBorrow = testOnBorrow;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public int getDataBase(){
		return dataBase;
	}
	
	public void setDataBase(int dataBase){
		this.dataBase = dataBase;
	}
	
	public String getHost(){
		return host;
	}
	
	public void setHost(String host){
		this.host = host;
	}
	
}
