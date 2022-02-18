package com.example.showweather.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class WeatherServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    private String getVilleFallback(String param) {
        return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - " + new Date();
    }

    @HystrixCommand(fallbackMethod = "getVilleFallback")
    public String getVilleByName(String name) {
        String response = restTemplate.exchange("http://weather/getVilleByName/{name}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, name).getBody();
        return "Informations de " + name + " : [" + response + "].";
    }

    @HystrixCommand(fallbackMethod = "getVilleFallback")
    public String getVilleByZipCode(String zip) {
        String response = restTemplate.exchange("http://weather/getVilleByZipCode/{zip}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, zip).getBody();
        return "Informations de " + zip + " : [" + response + "].";
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
