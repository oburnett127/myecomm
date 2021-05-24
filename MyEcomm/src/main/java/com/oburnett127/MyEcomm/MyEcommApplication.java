package com.oburnett127.MyEcomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.oburnett127.MyEcomm")
public class MyEcommApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEcommApplication.class, args);
	}

}