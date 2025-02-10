package fr.uha.serfa.lpdaoo25.bibliobook.controller;

import fr.uha.serfa.lpdaoo25.bibliobook.dao.UsagerRepo;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UsagerController {
    private final UsagerRepo usagerRepo;

    public UsagerController(UsagerRepo usagerRepo) {
        this.usagerRepo = usagerRepo;
        Usager usager = new Usager("Fred", "Fred", LocalDate.now(), 17);
        usagerRepo.save(usager);

        usagerRepo.findAll();
    }

//    @GetMapping("/usager")
//    public List<Usager> getAllUsagers() {
//
//    }


    public UsagerRepo getUsagerRepo() {
        return usagerRepo;
    }
}
