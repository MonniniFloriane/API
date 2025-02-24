package fr.uha.serfa.lpdaoo25.bibliobook.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Livre {
    @Id
    @GeneratedValue
    private int idLivre;

    private String titulo       = "";
    private String isbn         = "";
    private LocalDate datePubli = LocalDate.of(0, 1, 1);

    @ManyToOne
    @JoinColumn(name = "author_ID")
    private Auteur authora = new Auteur();

    public Livre() {
        this.authora.addLivre(this);
    }

    public Livre(String titulo, String isbn, LocalDate datePubli, Auteur authora) {
        this.titulo    = titulo;
        this.isbn      = isbn;
        this.datePubli = datePubli;
        this.authora   = authora;
        this.authora.addLivre(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDatePubli() {
        return datePubli;
    }

    public Auteur getAuthora() {
        return authora;
    }

    public void setAuthora(Auteur a) {
        this.authora = a;
        a.addLivre(this);
    }

    @Override
    public String toString() {
        return "Livres{" +
                "titulo='" + titulo + '\n' +
                "isbn=" + isbn + '\n' +
                "authora=" + authora + '\n' +
                '}';
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }
}
