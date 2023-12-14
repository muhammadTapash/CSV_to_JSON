package com.example.csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CsvApplication {
	
	@GetMapping("/hi")
	public String message() {
		
		return "welcome to WES";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CsvApplication.class, args);
	}

}
