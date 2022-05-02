package com.careedevs.helloInternet02.controllers;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
@SpringBootApplication
@RestController
@RequestMapping
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
    @GetMapping("/getPostbyId/{id}")
    public Object getPostById(RestTemplate restTemplate, @PathVariable String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Object.class);

    }
    @GetMapping("/posts/{id}/comments")
    public Object getCommentsByPost(RestTemplate restTemplate, @PathVariable String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts" + id + "/comments", Object.class);
    }

    @GetMapping("/comments")
    public Object getCommentsByQuery(RestTemplate restTemplate, @RequestParam String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?postId=" + id, Object.class);
    }


}

//url /endpoint : GET http://localhost:8080/getAllCoomments