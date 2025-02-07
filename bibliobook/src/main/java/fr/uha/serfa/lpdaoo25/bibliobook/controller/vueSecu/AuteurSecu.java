package fr.uha.serfa.lpdaoo25.bibliobook.controller.vueSecu;

import fr.uha.serfa.lpdaoo25.bibliobook.modele.Auteur;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuteurSecu {
    public String nom              = "James";
    public String prenom           = "Erika Leonard";
    public LocalDate dateNaissance = LocalDate.of(1963, 03, 07);
    public List<LivreSansAuthor> livres = new ArrayList<>();

    public AuteurSecu(Auteur auteur){
        this.nom           = auteur.getNom();
        this.dateNaissance = auteur.getNaissance();
        this.prenom        = auteur.getPrenom();
        for (Livre auteurTransform : auteur.getLivres()){
            LivreSansAuthor lsa = new LivreSansAuthor(auteurTransform);
            this.livres.add(lsa);
        }
    }
}
