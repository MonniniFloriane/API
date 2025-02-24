package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {
    @Id
    @GeneratedValue
    protected int id;

    protected String nom = "Jean";
    protected String prenom = "Jean";
    protected LocalDate dateNaissance = LocalDate.of(1663, 3, 7);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getNaissance() {
        return dateNaissance;
    }

    public void setNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
