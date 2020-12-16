
import java.io.*;

/**
 * Soittolista luokka soittolistan käsittelyyn.
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Soittolista extends MediaLista {

    /**
     * Soittolistan tiedoston nimi vakiona.
     */
    private final File tiedosto = new File("soittolista.txt");

    /**
     * Soittolistan suuruus.
     */
    private int maxkoko;

    /**
     * Kuormitin yliluokan metodin niin, että se saa tiedoston nimen suoraan
     * vakiosta.
     */
    public void lueTiedosto() {
        super.lueTiedosto(tiedosto);
        maxkoko = slkoko;
    }

    /**
     * Kuormitin yliluokan metodin niin, että se saa tiedoston nimen suoraan
     * vakiosta. Soittolistan tallenteeseen lisätään myös sen koko.
     */
    public void tallennaTiedosto() {
        slkoko = maxkoko;
        super.tallennaTiedosto(tiedosto);
    }

    /**
     * Korvattu yliluokan metodi. Soittolistan näytölle tulosteeseen lisätään
     * listan alkioden määrä ja listan koko.
     */
    public void tulostaNaytolle() {
        System.out.println(lista.koko() + " / " + maxkoko);
        super.tulostaNaytolle();
    }

    /**
     * Metodi yrittää tyhjentää soittolistan kaikki alkiot ja määrittää sen
     * uuden koon. Metodi tarkistaa onko tämä mahdollista, jos ei niin
     * tulosteaan virhe ja ei tehdä muutoksia.
     *
     * @param uusikoko soittolistan uusi koko on oltava >0 ja <=kirjaston koko
     * @param k
     * irjastonkoko kirjasto koko täytyy tietää
     */
    public void luo(int uusikoko, int kirjastonkoko) {
        if (uusikoko > 0 && uusikoko <= kirjastonkoko) {
            super.tyhjenna();
            maxkoko = uusikoko;
        } else {
            System.out.println("Virhe!");
        }
    }

    /**
     * Metodi yrittää lisätä median soittolistalle. Metodi tarkistaa onko se
     * mahdollista, jos ei niin tulostetaan virhe ja ei tehdä muutoksia.
     *
     * @param m lisättävä media ei saa olla listalla ja lista ei saa olla täynnä
     */
    public void lisaa(Media m) {
        if (m != null && lista.koko() < maxkoko && !lista.haeListalta(m)) {
            lista.lisaaLoppuun(m);
        } else {
            System.out.println("Virhe!");
        }
    }

    /**
     * Metodi yrittää poistaa alkiota listalta sen indeksi numeron perusteella.
     * Metodi tarkistaa indeksin arvon, jos se ei ole sopiva niin tulostetaan
     * virhe ja ei tehdä muutoksia.
     *
     * @param i ei saa olla negatiivinen eikä suurempi kuin listan koko
     */
    public void poista(int i) {
        if (i >= 0 && i < lista.koko()) {
            lista.poista(i);
        } else {
            System.out.println("Virhe!");
        }
    }

    /**
     * Metodi yrittää täyttää soittolistaa kirjaston medioilla. Jos media on jo
     * listalla tai lista on täynnä täyttö keskeytyy.
     *
     * @param kirjasto kirjasto
     */
    public void tayta(OmaLista kirjasto) {
        for (int i = 0; i < kirjasto.koko() && lista.koko() < maxkoko; i++) {
            Media m = (Media) kirjasto.alkio(i);

            //Jos havaitaan että media on jo listalla herjataan ja lopetetaan.
            if (lista.haeListalta(m)) {
                System.out.println("Virhe!");
                break;
            } else {
                lista.lisaaLoppuun(m);
            }
        }
    }
}
