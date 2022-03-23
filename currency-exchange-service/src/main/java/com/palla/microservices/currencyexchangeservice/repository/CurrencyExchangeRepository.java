package com.palla.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palla.microservices.currencyexchangeservice.data.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer>{

	CurrencyExchange findByFromAndTo(String from, String to);
}
