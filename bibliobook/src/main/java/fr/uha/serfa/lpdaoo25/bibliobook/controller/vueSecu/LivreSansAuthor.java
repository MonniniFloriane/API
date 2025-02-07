package fr.uha.serfa.lpdaoo25.bibliobook.controller.vueSecu;

import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;

import java.time.LocalDate;

public class LivreSansAuthor {
    public String titulo       = "Les Miserable";
    public String isbn         = "";
    public LocalDate datePubli = LocalDate.of(0, 1, 1);

    public LivreSansAuthor(Livre livre){
        this.titulo    = livre.getTitulo();
        this.isbn      = livre.getIsbn();
        this.datePubli = livre.getDatePubli();
    }
}
