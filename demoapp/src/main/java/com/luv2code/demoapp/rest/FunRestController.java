package com.luv2code.demoapp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String Hello(){
        return "Hello World. Server time: " + LocalDateTime.now();
    }
}
