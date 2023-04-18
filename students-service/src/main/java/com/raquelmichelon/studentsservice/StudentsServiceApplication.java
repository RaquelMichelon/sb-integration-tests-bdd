package com.raquelmichelon.studentsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StudentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsServiceApplication.class, args);
	}

}
