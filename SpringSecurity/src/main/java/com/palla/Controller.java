package com.palla;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Controller implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry controllerRegistry) {
		controllerRegistry.addViewController("/home").setViewName("home");
		controllerRegistry.addViewController("/").setViewName("home");
		controllerRegistry.addViewController("/hello").setViewName("hello");
		controllerRegistry.addViewController("/login").setViewName("login");
	}
}
