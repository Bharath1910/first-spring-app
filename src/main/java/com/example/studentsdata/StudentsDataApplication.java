package com.example.studentsdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsDataApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(StudentsDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world!");
	}
}
