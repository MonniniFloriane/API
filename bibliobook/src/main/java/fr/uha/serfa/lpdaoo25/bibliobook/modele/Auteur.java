package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Auteur extends Utilisateur {
    @OneToMany(mappedBy = "authora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livre> livres = new ArrayList<>();
    public String password     = "111";

    public Auteur() {}

    public Auteur(String nom, String prenom, LocalDate naissance) {
        this.nom       = nom;
        this.prenom    = prenom;
        this.dateNaissance = naissance;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<Livre> getLivres() { return livres; }

    public void addLivre(Livre livre) { this.livres.add(livre); }
}
