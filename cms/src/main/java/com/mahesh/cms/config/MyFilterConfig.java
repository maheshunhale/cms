package com.mahesh.cms.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mahesh.cms.filter.MyNewFilter;

@Configuration
public class MyFilterConfig {
	
	@Bean
	public FilterRegistrationBean<MyNewFilter> registrationBean(){
		
		FilterRegistrationBean<MyNewFilter> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new MyNewFilter());
		
		registrationBean.addUrlPatterns("/customers/*");
		
		return registrationBean;
	}
	
}
