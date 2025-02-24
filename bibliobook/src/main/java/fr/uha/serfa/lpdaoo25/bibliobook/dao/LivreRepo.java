package fr.uha.serfa.lpdaoo25.bibliobook.dao;

import fr.uha.serfa.lpdaoo25.bibliobook.modele.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepo extends JpaRepository<Livre,Long> {
}
