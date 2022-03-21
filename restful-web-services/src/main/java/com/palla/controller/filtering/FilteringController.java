package com.palla.controller.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.palla.data.SampleBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	@ResponseBody
	public MappingJacksonValue getSampleBean() {
		SampleBean samplebean = new SampleBean("Value1","Value2","Value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("simplefilter",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(samplebean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filterings")
	@ResponseBody
	public MappingJacksonValue getSampleBean2() {
		SampleBean samplebean = new SampleBean("Value11","Value22","Value33");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("simplefilter",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(samplebean);
		mapping.setFilters(filters);
		return mapping;
	}
}
