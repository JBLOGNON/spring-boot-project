package com.example.showweather;

import com.example.showweather.configuration.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@RibbonClient(name = "server", configuration = RibbonConfiguration.class)
@EnableEurekaClient
public class ShowWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowWeatherApplication.class, args);
    }

}
