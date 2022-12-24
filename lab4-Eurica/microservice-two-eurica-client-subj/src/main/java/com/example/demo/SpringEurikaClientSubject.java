package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurikaClientSubject {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringEurikaClientSubject.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
			throw ex;
		}
	}

}
