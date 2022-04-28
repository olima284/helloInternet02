package com.careedevs.helloInternet02.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@RestController
public class RootController {


    @GetMapping("/hello")
    private static String helloCareerDevs() {
        return "Hello to CareerDevs students";
    }

    @GetMapping("/getRequest")
    private static String getRequestedString() {
        return "Whats the String?";
    }

    @GetMapping("/randomNum")
    private static int getRandomNum() {

        int result = (int) Math.round(Math.random() * 100);

        return result;
    }

    @GetMapping("/joke")
    private String jokeRoute() {
        String[] jokes = {
                "Why did the cow jump over the moon",
                "knock! knock! Who there?",
                "Your Mama so Fat !"
        };
        int jokeIndex = (int) (Math.random() * jokes.length);
        return jokes[jokeIndex];

    }




    @GetMapping("/getAllComments")
    private Object allComments(RestTemplate restTemplate)
    {
        String allComments = "https://jsonplaceholder.typicode.com/comments";
        String url = " https://jsonplaceholder.typicode.com" + allComments;


       Object response= restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments",  Object.class);
       return response;
    }



}

//url /endpoint : GET http://localhost:8080/getAllCoomments