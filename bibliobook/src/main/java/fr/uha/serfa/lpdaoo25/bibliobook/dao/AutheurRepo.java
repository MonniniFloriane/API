package fr.uha.serfa.lpdaoo25.bibliobook.dao;

import fr.uha.serfa.lpdaoo25.bibliobook.modele.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AutheurRepo extends JpaRepository<Auteur,Long> {
    Set<Auteur> findByNom(String nom);
}
