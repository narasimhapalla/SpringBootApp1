package com.palla.controller;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.palla.data.HelloWorldBean;

@RestController
public class HelloWorld {

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
}
