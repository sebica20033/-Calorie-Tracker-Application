package com.example.proiectawj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.proiectawj") // Aici specifici pachetul principal
public class ProiectAwjApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProiectAwjApplication.class, args);
	}
}
