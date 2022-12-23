package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurikaClientAdjectives {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringEurikaClientAdjectives.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
			throw ex;
		}
	}

}
