package com.caracoles.saludback;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SaludbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludbackApplication.class, args);
	}

}
