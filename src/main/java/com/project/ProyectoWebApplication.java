package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ProyectoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoWebApplication.class, args);
	}

}
