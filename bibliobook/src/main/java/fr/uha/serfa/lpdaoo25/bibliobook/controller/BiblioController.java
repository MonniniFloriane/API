package fr.uha.serfa.lpdaoo25.bibliobook.controller;

import fr.uha.serfa.lpdaoo25.bibliobook.controller.vueSecu.AuteurSecu;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Auteur;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Biblioteque;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;
import fr.uha.serfa.lpdaoo25.bibliobook.utils.BibliotequeFactory;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;


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
    public Auteur getAuthor() {
        return new Auteur();
    }

    @GetMapping("/authorSecu")
    public AuteurSecu getAuthorSecuriser() {
        Auteur auteur = new Auteur();
        Livre livre   = new Livre("Titre 1", "IS16h", LocalDate.now(), auteur);
        auteur.addLivre(livre);
        return new AuteurSecu(auteur);
    }

    @GetMapping( "/auteurName/{name}")
    public List<AuteurSecu> getAuteurByName(@PathVariable(value= "name") String name) {
        Biblioteque b = BibliotequeFactory.getBigBibliotheque();
        Set<Auteur> auteurs = b.authorByName(name);

        List<AuteurSecu> auteurSecuList = new ArrayList<>();
        for (Auteur auteur : auteurs) {
            auteurSecuList.add(new AuteurSecu(auteur));
        }

        return auteurSecuList;
    }

    @PostMapping("/livre")
    public Biblioteque addLivre(@RequestBody Livre livre) {
        Biblioteque b = BibliotequeFactory.getBigBibliotheque();
        b.getLivres().add(livre);
        return b;
    }

    @GetMapping("/livre")
    public Livre getLivre() {
        return new Livre();
    }

    @GetMapping("/biblio")
    public Biblioteque getBiblioteque() {
        return new Biblioteque();
    }

    @GetMapping("/biblioBig")
    public Biblioteque bigBibliotheque(){
        return BibliotequeFactory.getBigBibliotheque();
    }
}
