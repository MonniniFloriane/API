package fr.uha.serfa.lpdaoo25.bibliobook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControl {

    @GetMapping
    public String hello() {
        return "<h1>Hello World!</h1>";
    }
}
