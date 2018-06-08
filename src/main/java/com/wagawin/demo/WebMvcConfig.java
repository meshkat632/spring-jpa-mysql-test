package com.wagawin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wagawin.demo.controller.RequestCounterInterceptor;
import com.wagawin.demo.controller.RequestTimingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	RequestCounterInterceptor requestCounterInterceptor;

	@Autowired
	RequestTimingInterceptor requestTimingInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestCounterInterceptor);
		registry.addInterceptor(requestTimingInterceptor);
	}
}