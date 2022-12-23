package com.example.demo;

import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    DiscoveryClient client;


    @Autowired

    RestTemplate restTemplate1;

    @GetMapping("/sentence")
    public @ResponseBody String getWord() {
        return getWord("spring-eureka-client-subject") + " "
                        + getWord("spring-eureka-client-verb") + " "
                        + getWord("spring-eureka-client-article") + " "
                        + getWord("spring-eureka-client-adjectives") + " "
                        + getWord("spring-eureka-client-noun") + "."
                ;
    }

    @GetMapping("/sentenceLoadBalance")
    public @ResponseBody String getWordLoadBalance() {
        return getWordLoadBalance("subject") + " "
                + getWordLoadBalance("spring-eureka-client-verb") + " "
                + getWordLoadBalance("spring-eureka-client-article") + " "
                + getWordLoadBalance("spring-eureka-client-adjectives") + " "
                + getWordLoadBalance("spring-eureka-client-noun") + "."
                ;
    }

    public String getWordLoadBalance(String service) {
        return restTemplate1.getForObject("http://" + service, String.class);
    }

    public String getWord(String service) {
        List<ServiceInstance> instances = client.getInstances(service);
        if (instances != null && instances.size() > 0) {
            URI uri = instances.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
