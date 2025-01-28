package fr.uha.serfa.lpdaoo25.bibliobook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliobookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliobookApplication.class, args);

		System.out.println("Bibliobook Application Started");
	}

}
