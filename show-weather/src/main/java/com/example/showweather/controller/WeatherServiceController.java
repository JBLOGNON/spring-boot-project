package com.example.showweather.controller;

import com.example.showweather.delegate.WeatherServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {

    @Autowired
    WeatherServiceDelegate weatherServiceDelegate;

    @RequestMapping(value = "/getVilleByName/{name}", method = RequestMethod.GET)
    public String getVilleByName(@PathVariable String name) {
        return weatherServiceDelegate.getVilleByName(name);
    }

    @RequestMapping(value = "/getVilleByZipCode/{zip}", method = RequestMethod.GET)
    public String getVilleByZipCode(@PathVariable String zip) {
        return weatherServiceDelegate.getVilleByZipCode(zip);
    }
}
