package fr.uha.serfa.lpdaoo25.bibliobook.controller.vueSecu;

import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivreSansAuthor {
    public String titulo       = "Les Miserable";
    public String isbn         = "";
    public LocalDate datePubli = LocalDate.of(0, 1, 1);
    private final List<LivreSansAuthor> livres = new ArrayList<>();
    
    public LivreSansAuthor() {}

    public void addLivre(Livre livre) {
        LivreSansAuthor LivreSansAuthor = null;
        this.livres.add(LivreSansAuthor); }

    public LivreSansAuthor(Livre livre){
        this.titulo    = livre.getTitulo();
        this.isbn      = livre.getIsbn();
        this.datePubli = livre.getDatePubli();
    }
}
