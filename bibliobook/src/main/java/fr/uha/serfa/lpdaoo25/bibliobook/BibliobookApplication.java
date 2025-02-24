package fr.uha.serfa.lpdaoo25.bibliobook;

import fr.uha.serfa.lpdaoo25.bibliobook.dao.AutheurRepo;
import fr.uha.serfa.lpdaoo25.bibliobook.modele.Biblioteque;
import fr.uha.serfa.lpdaoo25.bibliobook.utils.BibliotequeFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliobookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliobookApplication.class, args);

		System.out.println("Bibliobook Application Started");
	}

	@Bean
	CommandLineRunner initRepos(AutheurRepo auteurRepo) {
		return args -> {
			System.out.println("Initializing Repo");
			Biblioteque b = BibliotequeFactory.getBigBibliotheque();
			System.out.println(b.allAuthor());
			auteurRepo.saveAll(b.allAuthor());
		};
	}
}
