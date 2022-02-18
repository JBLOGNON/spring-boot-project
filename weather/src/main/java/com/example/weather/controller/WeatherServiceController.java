package com.example.weather.controller;

import com.example.weather.model.Ville;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
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

    @RequestMapping(value = "/getVilles")
    public List<Ville> getVilles() {
        return villeList;
    }

    @RequestMapping(value = "/getVilleByName/{name}", method = RequestMethod.GET)
    public Ville getVilleByName(@PathVariable(value = "name") String name) {
        return villeList.stream().filter(x -> x.getNomVille().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping(value = "/getVilleByZipCode/{zip}", method = RequestMethod.GET)
    public Ville getVilleByZipCode(@PathVariable(value = "zip") String zip) {
        return villeList.stream().filter(x -> x.getCodePostal().equalsIgnoreCase(zip)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping(value = "/getVilleByCountry/{country}", method = RequestMethod.GET)
    public List<Ville> getVilleByCountry(@PathVariable(value = "country") String country) {
        return villeList.stream().filter(x -> x.getPays().equalsIgnoreCase(country)).collect(Collectors.toList());
    }
}
