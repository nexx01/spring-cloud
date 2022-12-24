package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurikaClientArticle {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringEurikaClientArticle.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
			throw ex;
		}
	}

}
