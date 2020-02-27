package com.estudo.rest.webservices.restufulwebservices.bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Avisando que este é um arquivo de configuração
@Configuration
@EnableSwagger2
//Enable Swagger
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Ranga Karanam", "www.google.com", "google@gmail.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome Api Title", "Awesome Api Documentation", "2.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	private static final Set<String> DEFAULT_PRODUCES_AND_COSSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	
	
	// Bean - Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_COSSUMES);
	}
	
	
	// Bean - Docket
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2);
//	}
}
