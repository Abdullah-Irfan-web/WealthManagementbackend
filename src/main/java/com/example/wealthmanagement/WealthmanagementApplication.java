package com.example.wealthmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class WealthmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WealthmanagementApplication.class, args);
		System.out.print("Hello world jbhhy");
	}

}
