package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication

@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
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
	public Executor executor() {
		return Executors.newFixedThreadPool(6);
	}

}
