package com.palla.microservices.limitservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palla.microservices.limitservice.bean.Limits;
import com.palla.microservices.limitservice.configuration.Configuration;

@RestController
public class LimitsController {
	@Autowired
	private Configuration config;
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMinimum(),config.getMaximum());
	}

}
