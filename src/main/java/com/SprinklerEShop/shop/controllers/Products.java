package com.SprinklerEShop.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Products {
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
