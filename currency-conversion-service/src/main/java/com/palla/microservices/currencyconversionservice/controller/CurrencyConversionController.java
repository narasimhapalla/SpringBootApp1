package com.palla.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.palla.microservices.currencyconversionservice.data.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		//Rest template to trigger to rest api calls
		ResponseEntity<CurrencyConversion> resEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversion.class,
				uriVariables);
		CurrencyConversion cVersion = resEntity.getBody();
		return new CurrencyConversion(cVersion.getId(),
				cVersion.getFrom(),cVersion.getTo(),quantity,
				cVersion.getConversionMultiple(), quantity.multiply(cVersion.getConversionMultiple()) ,cVersion.getEnvironment());
	}
}
