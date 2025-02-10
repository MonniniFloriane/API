package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Usager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate naissance;
    private int nbrEmprunt;

    public Usager() {}

    public Usager(String nom, String prenom, LocalDate naissance, int nbrEmprunt) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.nbrEmprunt = nbrEmprunt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return naissance;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }

    public int getNbrEmprunt() {
        return nbrEmprunt;
    }

    public void setNbrEmprunt(int nbrEmprunt) {
        this.nbrEmprunt = nbrEmprunt;
    }
}
