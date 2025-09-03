package br.edu.utfpr.appdemo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("person")

public class PersonController {
    @GetMapping(value = {"", "/"})
    public String getPerson() {
        return "Olá, eu sou uma pessoa e funciono!";
    }

    @PostMapping("")
    public String create(@RequestBody String entity) {
        System.out.println(entity);
        
        return entity;
    }

    
}