package modele;

import java.time.LocalDate;

public class Autheur {
    private String nom          = "";
    private String prenom       = "";
    private LocalDate naissance = LocalDate.of(0, 1, 1);
    private final Livres livras;

    public Autheur(String nom, String prenom, LocalDate naissance, Livres livras) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.livras = livras;
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

    public Livres getLivras() {
        return livras;
    }

    @Override
    public String toString() {
        return "Autheur{" +
                "nom='" + nom + '\n' +
                "prenom='" + prenom + '\n' +
                "naissance=" + naissance + '\n' +
                "livras=" + livras + '\n' +
                '}';
    }
}
