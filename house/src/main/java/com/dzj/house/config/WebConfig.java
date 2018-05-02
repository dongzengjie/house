package com.dzj.house.config;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	
	@Autowired
	private UserArgementResolver userArgementResolver;
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper =	new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return objectMapper;
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
	
		argumentResolvers.add(userArgementResolver);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
		
	}
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			//basePath = "C:/house/image";
			
			registry.addResourceHandler("/upload/**").addResourceLocations("file:///C:/house/image/upload/");
		} else {
			registry.addResourceHandler("/upload/**").addResourceLocations("file:////usr/local/house/work/image/upload/");
			
		}
		
		
		
	}
	
}
