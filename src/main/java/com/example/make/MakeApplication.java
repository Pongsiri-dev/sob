package com.example.make;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MakeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("spring.jackson.serialixation.IDENT_OUTPUT", "true");
		SpringApplication.run(MakeApplication.class, args);		
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MakeApplication.class);
    }
	
}
