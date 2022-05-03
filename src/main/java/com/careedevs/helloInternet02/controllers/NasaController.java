package com.careedevs.helloInternet02.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/nasa")
//localhost:8080/nasa/
public class NasaController {
//assigned as a string with the api key
    private final String myNasaKey = "sKewRHb982KWI7QoEKZ9YhdLwkLpdzAcht9Jrnwe";

    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey ;
//add route handler
//localhost:8080/nasa/apod
@GetMapping("/apod")
    public Object apodHander (RestTemplate restTemplate) {
    return restTemplate.getForObject(nasaApodEndpoint, Object.class);
}
    private String getApodDate;



    @GetMapping ("/nasa/apod/{date}")
    public Object apodHandler (RestTemplate restTemplate){
        return restTemplate.getForObject(nasaApodEndpoint + myNasaKey + getApodDate,  Object.class );
    }

    @GetMapping("/nasa/apod/{date}")
    public  String getApodDate(@PathVariable String date){
        return "DATE: " + date;
    }
}


