package com.vnpost.e_learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vnpost.e_learning.constants.SystemConstant;

@Configuration
public class AdditionalResourceWebConfiguration  implements WebMvcConfigurer {
	
	@Override
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/media/**").addResourceLocations("file:"+SystemConstant.BASE_DIR+"/product");
	  }
	
	
	
}
