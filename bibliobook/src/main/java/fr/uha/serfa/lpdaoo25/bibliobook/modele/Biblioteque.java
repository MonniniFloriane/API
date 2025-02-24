package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteque  {
    private String adress      = "";
    private String nom         = "";
    private List<Livre> livres = new ArrayList<>();

    public Biblioteque(){
        livres.add(new Livre());
        livres.add(new Livre("Jardinage", "IS56", LocalDate.of(1996,3,5), new Auteur("Jean", "Jean", LocalDate.now())));
    }

    public Biblioteque(String adress, String nom, List<Livre> livres) {
        this.adress = adress;
        this.nom    = nom;
        this.livres = livres;
    }

    public String getAdress() {
            return adress;
    }

    public String getNom() {
        return nom;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public Set<Auteur> allAuthor() {
        Set<Auteur> auteurs = new HashSet<>();

        for (Livre livre : this.livres){
            auteurs.add(livre.getAuthora());
        }
        return auteurs;
    }

    public Set<Auteur> authorByName(String name) {
        Set<Auteur> auteursName = new HashSet<>();
        for(Auteur auteur : this.allAuthor()){
            if(auteur.getNom().contains(name)){
                auteursName.add(auteur);
            };
        }
        return auteursName;
    }
}
