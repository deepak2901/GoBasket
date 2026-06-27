package com.gobasket.gobasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gobasket")
public class GobasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GobasketApplication.class, args);
	}

}
