package com.dzj.house.redis;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class RedisService {

	@Autowired
	private  StringRedisTemplate redisTemplate;

	@Autowired
	private  ObjectMapper objectMapper;

	public  <T> T getObjectValue(String key, Class<T> clazz) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		T value = null;
		String resultStr = ops.get(key);
		try {
			value = objectMapper.readValue(resultStr, clazz);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}
	
	public <T> void setObjectValue(String key,T value ,int overTime) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		String resultStr=null;
		try {
			resultStr = objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ops.set(key, resultStr, overTime, TimeUnit.SECONDS);
			
	}
	
	public  boolean hasObject(String key) {
		
		
		return redisTemplate.hasKey(key);
		
	}
}
