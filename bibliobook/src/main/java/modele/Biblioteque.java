package modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Biblioteque extends Livres {
        private String adress = "";

        public Biblioteque(String adress) {
            super("Les Misérable", "Marvel", 1554);
            this.adress = adress;
        }

        public String getAdress() {
            return adress;
        }

    @Override
    public String toString() {
        return "Biblioteque{" + "adress=" + adress + '}';
    }
}
