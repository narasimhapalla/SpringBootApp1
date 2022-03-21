package com.palla.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.palla.data.HelloWorldBean;

@RestController
public class HelloWorld {
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/hellow-world")
	public String helloWorld() {
		return new String("Hello World");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hellow-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	@RequestMapping(method = RequestMethod.GET, path = "/hellow-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World "+ name);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloworld/i18n")
	public String helloWorli18n(
			//@RequestHeader(name = "Accept-Language" , required = false) Locale locale
			) {
		//return new HelloWorldBean("Hello World ");
		return messageSource.getMessage("good.morning.message", null,"Default message", LocaleContextHolder.getLocale());
	}
	
}
