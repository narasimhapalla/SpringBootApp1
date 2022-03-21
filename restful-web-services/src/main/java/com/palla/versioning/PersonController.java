package com.palla.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping("/v1/person")
	private PersonV1 getPersonV1() {
		return new PersonV1("Bob CHARLE");
	}
	
	@GetMapping("/v2/person")
	private PersonV2 getPersonV2() {
		return new PersonV2(new Name("Bob", "CHARLE"));
	}
	
	@GetMapping(value="/person/param", params = "value=1")
	private PersonV1 getParamV1() {
		return new PersonV1("Bob CHARLE");
	}
	
	@GetMapping(value="/person/param", params = "value=2")
	private PersonV2 getParamV2() {
		return new PersonV2(new Name("Bob", "CHARLE"));
	}
	
	@GetMapping(value="/person/header", headers = "X-API-VERSION=1")
	private PersonV1 getHeaderV1() {
		return new PersonV1("Bob CHARLE");
	}
	
	@GetMapping(value="/person/header", headers = "X-API-VERSION=2")
	private PersonV2 getHeaderV2() {
		return new PersonV2(new Name("Bob", "CHARLE"));
	}
	
	@GetMapping(value="/person/produces", produces = "application/palla.company.app-v1+json")
	private PersonV1 getProdV1() {
		return new PersonV1("Bob CHARLE");
	}
	
	@GetMapping(value="/person/produces", produces = "application/palla.company.app-v2+json")
	private PersonV2 getProdV2() {
		return new PersonV2(new Name("Bob", "CHARLE"));
	}
	
}
