package com.pandahun.baseentitytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BaseentitytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseentitytestApplication.class, args);
	}

}
