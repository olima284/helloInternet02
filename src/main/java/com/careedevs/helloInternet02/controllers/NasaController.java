package com.careedevs.helloInternet02.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
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
    private String myNasaKey = "sKewRHb982KWI7QoEKZ9YhdLwkLpdzAcht9Jrnwe";
    //Url endpoint //
    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey ;

    //add route handler
//localhost:8080/nasa/apod
    @GetMapping("/apod")
    public Object apodHander(RestTemplate restTemplate) {
        return restTemplate.getForObject(nasaApodEndpoint, Object.class);
    }

    //localhost:8080/nasa/apod/2022-05-03
    // Get astronomy image based on date value
    @GetMapping("/nasa/apod/{date}")
    public Object apodHandler(RestTemplate restTemplate, @PathVariable String date) {
        String url = nasaApodEndpoint + myNasaKey + "&date="+  date;
        System.out.println(url);
        return restTemplate.getForObject(url, Object.class);
    }

}
//GET methods request data from a specified request url
//query string (parameter/value pairs)
//}
//
//
