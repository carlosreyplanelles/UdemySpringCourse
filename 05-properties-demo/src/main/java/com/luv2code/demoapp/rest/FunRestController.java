package com.luv2code.demoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coach;

    @Value("${team.name}")
    private String team;

    @GetMapping("/")
    public String Hello(){
        return "Hello coach " + coach + ". Server time: " + LocalDateTime.now();
    }
    @GetMapping("/workout")
    public String getDailyTraining(){
        return"Run 5 Km";
    }
}
