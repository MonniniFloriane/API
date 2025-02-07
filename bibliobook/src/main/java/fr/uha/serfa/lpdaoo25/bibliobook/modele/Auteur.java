package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Auteur {
    private String nom               = "";
    private String prenom            = "";
    private LocalDate naissance      = LocalDate.of(0, 1, 1);
    private final List<Livre> livres = new ArrayList<>();
    public String password           = "111";

    public Auteur() {}

    public Auteur(String nom, String prenom, LocalDate naissance) {
        this.nom       = nom;
        this.prenom    = prenom;
        this.naissance = naissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    @JsonIgnore
    public List<Livre> getLivres() { return livres; }

    public void addLivre(Livre livre) { this.livres.add(livre); }

    @Override
    public String toString() {
        return "Autheur{" +
                "nom='" + nom + '\n' +
                "prenom='" + prenom + '\n' +
                "naissance=" + naissance + '\n' +
                '}';
    }
}
