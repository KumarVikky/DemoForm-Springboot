package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.demo.model")
public class DemoFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFormApplication.class, args);
	}

}
