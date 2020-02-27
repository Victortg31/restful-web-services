package com.estudo.rest.webservices.restufulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class RestufulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestufulWebServicesApplication.class, args);
	}
	
	
	//criando uma bean para pegar o localização do acesso e assim definir o idioma
//	@Bean
//	public LocaleResolver localeResolver() {
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.US);
//		
//		return localeResolver;
//	}
	


}
