package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Usager extends Utilisateur{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Livre emprunt;

    public Livre getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Livre emprunt) {
        this.emprunt = emprunt;
    }

    public Usager() {}

    public Usager(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = naissance;
    }

    public int getNbrEmprunt() {
        if(this.hasLivreEmprunt())
            return 1;
        return 0;
    }

    public boolean hasLivreEmprunt() {
        return this.emprunt == null;
    }

    @Override
    public String toString() {
        return "Usager {" +
                "id        : " + id + "\n" +
                "nom       : " + nom + "\n" +
                "prenom    : " + prenom + "\n" +
                "naissance : " + dateNaissance;
    }
}
