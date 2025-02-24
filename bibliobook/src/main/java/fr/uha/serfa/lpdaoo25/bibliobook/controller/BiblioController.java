package fr.uha.serfa.lpdaoo25.bibliobook.controller;

import fr.uha.serfa.lpdaoo25.bibliobook.controller.vueSecu.AuteurSecu;
import fr.uha.serfa.lpdaoo25.bibliobook.dao.AutheurRepo;
import fr.uha.serfa.lpdaoo25.bibliobook.dao.LivreRepo;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Auteur;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Biblioteque;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;
import fr.uha.serfa.lpdaoo25.bibliobook.utils.BibliotequeFactory;
import net.datafaker.Faker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;


@RestController
public class BiblioController {
    private final AutheurRepo auteurRepos;
    private final LivreRepo livreRepos;

    public BiblioController(AutheurRepo auteurRepos, LivreRepo livreRepos) {
        this.auteurRepos = auteurRepos;
        this.livreRepos = livreRepos;

        Faker faker = new Faker();
        System.out.println(faker.gender().types());
        System.out.println(faker.beer().name());
        System.out.println(faker.bojackHorseman().quotes());
        System.out.println(faker.community().quote());
        System.out.println(faker.emoji().cat());

        BibliotequeFactory.addRamdomBook(5);
    }

    @GetMapping("/author")
    public List<Auteur> getAuthor() {
        return this.auteurRepos.findAll();
    }

    @PostMapping("/randomName")
    public Auteur ajoutAuteurAleatoire(){
        Faker faker = new Faker();
        String nom = faker.onePiece().character();
        String prenom = faker.tron().character();
        LocalDate naissance = faker.timeAndDate().birthday(19, 500);
        Auteur a = new Auteur(nom, prenom, naissance);

        String titre = faker.book().title();
        String isbn = faker.code().isbn10();
        LocalDate datePublication = faker.timeAndDate().birthday(19, 500);
        Livre l = new Livre(titre, isbn, datePublication, a);

        a= this.auteurRepos.save(a);

        return a;
    }

    /**
     * renvoit un auteur sécurisé ; un auteur sans password et dont le livre n'affiche pas son auteur (evite la récursivité)
     * explicite l'usage de DTO pour masquer des informations
     * mappé sur la route /bibliotook/auteurLivre
     * @return
     */
    @GetMapping("/authorSecu")
    public AuteurSecu getAuthorSecuriser() {
        Auteur auteur = new Auteur();
        Livre livre   = new Livre("Titre 1", "IS16h", LocalDate.now(), auteur);
        auteur.addLivre(livre);
        return new AuteurSecu(auteur);
    }

    /**
     * permet de récupérer la liste de tous les auteurs dont le nom match avec le paramettre d'URL "name"
     * mappé sur la route /bibliotook/auteur/name
     * @param nameSearch - mappé avec "name"
     * @return les auteurs récupérés sont des auteurs sécurisés (pas de password, livres n'affichent pas leurs auteurs
     */
    @GetMapping( "/auteurName/{name}")
    public List<AuteurSecu> getAuteurName(@PathVariable(value = "name") String nameSearch) {

        Set<Auteur> auteurs = auteurRepos.findByNom(nameSearch);

        List<AuteurSecu> auteurSecuList = new ArrayList<>();
        for (Auteur auteur : auteurs) {
            auteurSecuList.add(new AuteurSecu(auteur));
        }

        return auteurSecuList;
    }

    /**
     * premier post réalisé
     * receptionne un livre sous forme de JSON et l'ajoute à la bibliothèque
     * mappé sur /bibliotook/livre
     * @param livre - un livre transformé par jackson depuis le corp de la requete
     * @return la bibliotèque avec le livre ajouté
     */
    @PostMapping("/livre")
    public Biblioteque addLivre(@RequestBody Livre livre) {
        Biblioteque b = BibliotequeFactory.getBigBibliotheque();
        b.getLivres().add(livre);
        return b;
    }

    /**
     * une route qui permet d'ajouter un livre à la bibliothèque
     * l'auteur du livre est passé en argument de la route
     * si l'auteur n'existe pas dans la bibliothèque le livre n'est pas ajouté
     * la route ajouter "ajouter livre a auteur existant" de postman permet de tester cette route
     * mappée sur /bibliotook/livre/auteurNom
     * @return
     */
    @PostMapping("/livre/{authorName}")
    public ResponseEntity<Biblioteque> addLivreSecure(@RequestBody Livre livre, @PathVariable(value= "authorName") String authorName) {
        Biblioteque b = BibliotequeFactory.getBigBibliotheque();
        Set<Auteur> auteurs = b.authorByName(authorName);

        for (Auteur a : auteurs) {
            if(a.getNom().equals(authorName)) {
                b.getLivres().add(livre);
                livre.setAuthora(a);
                return new ResponseEntity<>(b, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * renvoi une nouvelle instance de livre
     * mappé sur la route /bibliotook/livre
     * @return
     */
    @GetMapping("/livre")
    public Livre getLivre() {
        return new Livre();
    }

    /**
     * renvoi une nouvelle instance de bibliothèque
     * mappé sur la route /bibliotook/bibliotheque
     * @return
     */
    @GetMapping("/biblio")
    public Biblioteque getBiblioteque() {
        return new Biblioteque();
    }

    /**
     * renvoi la bibliothèque singleton existant dans le serveur.
     * mappé sur la route /bibliotook/bibliothequeBig
     * @return
     */
    @GetMapping("/biblioBig")
    public Biblioteque bigBibliotheque(){
        return BibliotequeFactory.getBigBibliotheque();
    }
}
