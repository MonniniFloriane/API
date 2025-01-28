package fr.uha.serfa.lpdaoo25.bibliobook.controller;

import modele.Autheur;
import modele.Livres;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.time.LocalDate;


@RestController
public class BiblioController {

    public BiblioController() {
        System.err.println("Hello World Control");
    }

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/truc")
    public String helloTruc() {
        return "<h1>Hello Truc!</h1>";
    }

    @GetMapping("/color")
    public Color helloColor() {
        return Color.BLUE;
    }

    @GetMapping("/author")
    public Autheur getAuthor() {
        return new Autheur("Freud", "Alber", LocalDate.of(1998, 9, 19), getClass(Livres));
    }


}
