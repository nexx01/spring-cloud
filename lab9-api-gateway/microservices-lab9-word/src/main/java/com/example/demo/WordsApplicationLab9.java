package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WordsApplicationLab9 {

	public static void main(String[] args) {
		try {
			SpringApplication.run(WordsApplicationLab9.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
			throw ex;
		}
	}


}
