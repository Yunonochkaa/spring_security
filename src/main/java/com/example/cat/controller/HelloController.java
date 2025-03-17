package com.example.cat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Это публичная конечная точка, доступная без аутентификации";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "Это частная конечная точка, доступная только после аутентификации";
    }
}
