package com.marcohaiat.catalog_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CatalogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApiApplication.class, args);
	}

}
