package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

@EnableDiscoveryClient
public class SentenceApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SentenceApplication.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	//	This "LoadBalanced" RestTemplate
	//	is automatically hooked into Ribbon:
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
