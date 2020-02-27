package com.estudo.rest.webservices.restufulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.rest.webservices.restufulwebservices.bean.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	private static String OPERAÇÃO_SOME_BEAN = "1";
	private static String OPERAÇÃO_RETRIEVE_LIST = "2";
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {

		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		MappingJacksonValue mapping = filterGeneric(someBean,null,OPERAÇÃO_SOME_BEAN);

		return mapping;
	}


	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveList() {
		// retornandouma lista
		// return Arrays.asList(new SomeBean("value1", "value2", "value3"), new
		// SomeBean("value12", "value22", "value32"));

		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value12", "value22", "value32"));

		MappingJacksonValue mapping = filterGeneric(null,list,OPERAÇÃO_RETRIEVE_LIST);

		return mapping;

	}
	
	private MappingJacksonValue filterGeneric(SomeBean someBean, List<SomeBean> list, String op) {
		// Estou dizendo para filtro.. filtre todos exceto esses dois campos
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

		// criei uma variavel local
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping;
		// Filtrando uma variavel específica
		if("1".equalsIgnoreCase(op)) {
			mapping = new MappingJacksonValue(someBean);
		}else {
			mapping = new MappingJacksonValue(list);
		}
		mapping.setFilters(filters);
		return mapping;
	}
}
