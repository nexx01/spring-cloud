package com.example.demo;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class SpringEurikaClientSentense {

	@Autowired
	DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringEurikaClientSentense.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
			throw ex;
		}
	}

	//  This "LoadBalanced" RestTemplate
	//  is automatically hooked into Ribbon:
	@Bean
	@LoadBalanced
	RestTemplate restTemplate1() {
		return new RestTemplate();
	}

//	@Bean
//	public ServerList<Server> getServerList(IClientConfig config) {
//
//		return new ServerList<Server>() {
//			@Override
//			public List<Server> getInitialListOfServers() {
//				return new ArrayList<>();
//			}
//
//			@Override
//			public List<Server> getUpdatedListOfServers() {
//				List<Server> serverList = new ArrayList<>();
//
//				List<ServiceInstance> list = discoveryClient.getInstances(config.getClientName());
//				for (ServiceInstance instance : list) {
//					serverList.add(new Server(instance.getHost(), instance.getPort()));
//				}
//				return serverList;
//			}
//		};
//	}

}
