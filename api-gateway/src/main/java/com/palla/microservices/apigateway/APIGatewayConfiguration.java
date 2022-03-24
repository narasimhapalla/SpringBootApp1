package com.palla.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * API gateway configuration to add custom urls through api gate way
 * you can add custom headers to the request
 * you can add request parameters as well
 * you can change the request URL
 * @author jala_pa
 *
 */
@Configuration
public class APIGatewayConfiguration {

	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("Param", "MyValue"))
					.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-new/**")
						.filters(f -> f.rewritePath(
								"/currency-conversion-new/(?<segment>.*)", 
								"/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
		
		/*
		 * 		Function<PredicateSpec, Buildable<Route>> routeFunction
		= p -> p.path("/get")
		.filters(f -> f.addRequestHeader("MyHeader", "MyURI")
				.addRequestParameter("Param", "MyValue"))
			.uri("http://httpbin.org:80");
		return builder.routes()
				.route(routeFunction)
				.build();
		 */
	}
}
