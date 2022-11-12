package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class Covid19VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19VaccinationApplication.class, args);
	}
	
	
}
