package fr.uha.serfa.lpdaoo25.bibliobook.controller;

import fr.uha.serfa.lpdaoo25.bibliobook.dao.LivreRepo;
import fr.uha.serfa.lpdaoo25.bibliobook.dao.UsagerRepo;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Usager;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UsagerController {
    private final UsagerRepo usagerRepo;
    private final LivreRepo LivreRepo;

    public UsagerController(UsagerRepo UsagerRepo, LivreRepo LivreRepo) {
        this.usagerRepo = UsagerRepo;
        this.LivreRepo = LivreRepo;

        usagerRepo.save(new Usager());
        Usager u = new Usager("Fred", "Fred", LocalDate.now());
        usagerRepo.save(u);

        System.out.println(usagerRepo.findAll());
    }

    @GetMapping("/usager")
    public List<Usager> getAllUsagers() {
        return usagerRepo.findAll();
    }

    @GetMapping("/usager/{id}")
    public ResponseEntity<Usager> getUsagerById(@PathVariable Long id) {
        Optional<Usager> usagerOptional = usagerRepo.findById(id);
        return usagerOptional.map(usager -> new ResponseEntity<>(usager, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/usager")
    public Usager addUsager(@RequestBody Usager usager) {
        return usagerRepo.save(usager);
    }

    @DeleteMapping("/usager/{id}")
    public void deleteUsagerById(@PathVariable Long id) {
        usagerRepo.deleteById(id);
    }

    @PatchMapping("usager/{id}")
    public void deleteUsagerById(@PathVariable Long id, @RequestBody Usager usager) {
        Usager usager1 = usagerRepo.getReferenceById(id);
        usager1.setNaissance(usager.getNaissance());
        usager1.setNom(usager.getNom());
        usager1.setPrenom(usager.getPrenom());
    }

    @PostMapping("/usager/{idUsager}/emprunt/{idLivre}")
    public ResponseEntity<Usager> emprunter(@PathVariable Long idUsager, @PathVariable Long idLivre) {

        Optional<Usager> optionalUsager = usagerRepo.findById(idUsager);
        if(optionalUsager.isEmpty())
            return ResponseEntity.notFound().build();

        Optional<Livre> optionalLivre = LivreRepo.findById(idLivre);
        if(optionalLivre.isEmpty())
            return ResponseEntity.notFound().build();

        Usager u = optionalUsager.get();
        Livre l = optionalLivre.get();

        if(u.getEmprunt() != null)
            return ResponseEntity.badRequest().build();

        u.setEmprunt(l);
        usagerRepo.save(u);

        return ResponseEntity.ok().body(u);
    }
}
