
import java.io.*;

/**
 * MediaLista luokka on yliluokka soittolistalle ja kirjastolle.
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class MediaLista {

    /**
     * MediaLista käyttää OmaListaa attribuuttinaan
     */
    protected OmaLista lista = new OmaLista();
    /**
     * Huono apu attribuutti koska kirjasto ei tätä käytä
     */
    protected int slkoko;

    /**
     * Metodi poistaa listalta kaikki alkiot.
     */
    public void tyhjenna() {
        int listankoko = lista.koko();
        for (int i = 0; i <= listankoko; i++) {
            lista.poistaAlusta();
        }
    }

    /**
     * Metodilla luetaan tiedoston rivit. Rivien tietojen perusteella luodaan
     * uudet oliot ja tallennetaan ne listalle. Soittolista tiedostosta
     * tallennetaan myös sen koko slkoko attribuuttiin.
     *
     * @param tiedosto Tiedoston nimi josta tietoa luetaan.
     */
    public void lueTiedosto(File tiedosto) {
        try {
            BufferedReader lukija = new BufferedReader(new FileReader(tiedosto));
            while (lukija.ready()) {
                // Luetaan tiedoston rivi ja jaetaan osiin.
                String rivi = lukija.readLine();
                String[] osa = rivi.split("[|]");

                // Trimmataan jaetut osat lukukelpoisiksi.
                for (int i = 0; i < osa.length; i++) {
                    osa[i] = osa[i].trim();
                }

                // Tehdään osista oliot ja tallennetaan ne listaan.
                if (osa[0].contains("Video")) {
                    Video v = new Video(osa[1], osa[2]);
                    lista.lisaaLoppuun(v);
                } else if (osa[0].contains("Aani")) {
                    Aani a = new Aani(osa[1], Integer.parseInt(osa[2]));
                    lista.lisaaLoppuun(a);
                } else if (osa[0].contains("Kuva")) {
                    Kuva k = new Kuva(osa[1], Boolean.parseBoolean(osa[2]));
                    lista.lisaaLoppuun(k);
                } else if (Liittyma.onkoLuku(osa[0])) {
                    slkoko = Integer.parseInt(osa[0]);// Soittolistan koko
                }
            }
            lukija.close();

            // Napataan poikkeukset 
        } catch (FileNotFoundException e) {
            System.out.print(e.toString());
        } catch (IOException e) {
            System.out.print(e.toString());
        } catch (NumberFormatException e) {
            System.out.print(e.toString());
        }
    }

    /**
     * Metodilla tulostetaan listan tiedot näytölle muotoiltuna. Tulosteeseen
     * lisätään myös listan indeksit.
     */
    public void tulostaNaytolle() {
        for (int i = 0; i < lista.koko(); i++) {
            int luvunpituus = Integer.toString(i).length();
            System.out.println(Liittyma.muotoile(luvunpituus, 3, i) + lista.alkio(i));
        }
    }

    /**
     * Metodilla kirjoitetaan listan sisältö tiedostoon muotoiltuna. Soittolista
     * tiedostoon kirjoitetaan myös slkoko attribuutti ensimmäiselle riville.
     *
     * @param tiedosto Tiedoston nimi tallenetaan.
     */
    public void tallennaTiedosto(File tiedosto) {
        try {
            BufferedWriter kirjoittaja = new BufferedWriter(new FileWriter(tiedosto));
            String rivi;
            // Tarkistetaan ensin tehdäänkö soittolistaa.
            if (tiedosto.getName().equals("soittolista.txt")) {
                rivi = Integer.toString(slkoko);
                rivi = Liittyma.muotoile(rivi.length(), 8, slkoko);
                kirjoittaja.write(rivi);
                kirjoittaja.newLine();
            }
            // Kirjoitetaan rivi riviltä.
            for (int i = 0; i < lista.koko(); i++) {
                rivi = lista.alkio(i).toString();
                kirjoittaja.write(rivi);
                kirjoittaja.newLine();
            }
            kirjoittaja.close();

            // Siepataan poikkeus
        } catch (IOException e) {
            System.out.print(e.toString());
        }
    }
}
