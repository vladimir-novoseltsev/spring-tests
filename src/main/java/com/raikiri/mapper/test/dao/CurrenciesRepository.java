package com.raikiri.mapper.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.raikiri.mapper.test.model.dictionary.Currency;

public interface CurrenciesRepository extends CrudRepository<Currency, Long>{
	Currency getByCode(String code);
	
	@Override
	List<Currency> findAll();
}
