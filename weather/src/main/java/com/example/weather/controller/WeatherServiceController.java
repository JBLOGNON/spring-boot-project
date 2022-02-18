package com.example.weather.controller;

import com.example.weather.model.Ville;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "WeatherServiceController", description = "Service to retrieve weather from city, zipcode, or of all city in specific country")
@RestController
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
public class WeatherServiceController {

    public static final List<Ville> villeList = new ArrayList<Ville>() {
        private static final long serialVersionUID = -3970206781360313502L;
        {
            add(new Ville("Nice", "06000", "France", "Il fait 25°C"));
            add(new Ville("Paris", "75000", "France", "Il fait 15°C"));
            add(new Ville("Marseille", "13000", "France", "Il fait 20°C"));
            add(new Ville("New York", "10001", "USA", "Il fait 18°C"));
            add(new Ville("Washington D.C", "10002", "USA", "Il fait 22°C"));
            add(new Ville("Tokyo", "10003", "Japon", "Il fait 27°C"));
        }
    };

    @ApiOperation(value = "Get weathers of all cities", response = Iterator.class, tags = "getVilles")
    @RequestMapping(value = "/getVilles", method = RequestMethod.GET)
    public List<Ville> getVilles() {
        return villeList;
    }

    @ApiOperation(value = "Get weathers by city name", response = Ville.class, tags = "getVilleByName")
    @RequestMapping(value = "/getVilleByName/{name}", method = RequestMethod.GET)
    public Ville getVilleByName(@PathVariable(value = "name") String name) {
        return villeList.stream().filter(x -> x.getNomVille().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get weathers by city zip code", response = Ville.class, tags = "getVilleByZipCode")
    @RequestMapping(value = "/getVilleByZipCode/{zip}", method = RequestMethod.GET)
    public Ville getVilleByZipCode(@PathVariable(value = "zip") String zip) {
        return villeList.stream().filter(x -> x.getCodePostal().equalsIgnoreCase(zip)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get weathers by cities from a specific country", response = Iterator.class, tags = "getVilleByCountry")
    @RequestMapping(value = "/getVilleByCountry/{country}", method = RequestMethod.GET)
    public List<Ville> getVilleByCountry(@PathVariable(value = "country") String country) {
        return villeList.stream().filter(x -> x.getPays().equalsIgnoreCase(country)).collect(Collectors.toList());
    }
}
