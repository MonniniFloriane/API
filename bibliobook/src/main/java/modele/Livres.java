package modele;

import java.io.Serializable;
import java.time.LocalDate;

public class Livres {
    private String titulo  = "";
    private String editora = "";
    private final Autheur authora;
    private int isbn       = 0;

    public Livres(String titulo, String editora, Autheur authora, int isbn) {
        this.titulo  = titulo;
        this.editora = editora;
        this.authora = authora;
        this.isbn    = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public Autheur getAuthora() {
        return authora;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Livres{" +
                "titulo='" + titulo + '\n' +
                "editora='" + editora + '\n' +
                "authora=" + authora + '\n' +
                "isbn=" + isbn + '\n' +
                '}';
    }
}
