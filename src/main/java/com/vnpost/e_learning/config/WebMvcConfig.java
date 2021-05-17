package com.vnpost.e_learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//   file:D:\\data\\file\\image\\
		registry.addResourceHandler("/public/image/**").addResourceLocations("/template/uploadmedia/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/ckfinder/**").addResourceLocations("/template/ckfinder/");
		registry.addResourceHandler("/images/**").addResourceLocations("file:///D:/images/");
		super.addResourceHandlers(registry);
	}
	
	
	 
}
