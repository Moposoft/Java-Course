
import java.io.*;

/**
 * Soittolista luokka soittolistan k�sittelyyn.
 * <p>
 * Harjoitusty� Olio-ohjelmoinnin perusteet.
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
     * Kuormitin yliluokan metodin niin, ett� se saa tiedoston nimen suoraan
     * vakiosta.
     */
    public void lueTiedosto() {
        super.lueTiedosto(tiedosto);
        maxkoko = slkoko;
    }

    /**
     * Kuormitin yliluokan metodin niin, ett� se saa tiedoston nimen suoraan
     * vakiosta. Soittolistan tallenteeseen lis�t��n my�s sen koko.
     */
    public void tallennaTiedosto() {
        slkoko = maxkoko;
        super.tallennaTiedosto(tiedosto);
    }

    /**
     * Korvattu yliluokan metodi. Soittolistan n�yt�lle tulosteeseen lis�t��n
     * listan alkioden m��r� ja listan koko.
     */
    public void tulostaNaytolle() {
        System.out.println(lista.koko() + " / " + maxkoko);
        super.tulostaNaytolle();
    }

    /**
     * Metodi yritt�� tyhjent�� soittolistan kaikki alkiot ja m��ritt�� sen
     * uuden koon. Metodi tarkistaa onko t�m� mahdollista, jos ei niin
     * tulosteaan virhe ja ei tehd� muutoksia.
     *
     * @param uusikoko soittolistan uusi koko on oltava >0 ja <=kirjaston koko
     * @param k
     * irjastonkoko kirjasto koko t�ytyy tiet��
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
     * Metodi yritt�� lis�t� median soittolistalle. Metodi tarkistaa onko se
     * mahdollista, jos ei niin tulostetaan virhe ja ei tehd� muutoksia.
     *
     * @param m lis�tt�v� media ei saa olla listalla ja lista ei saa olla t�ynn�
     */
    public void lisaa(Media m) {
        if (m != null && lista.koko() < maxkoko && !lista.haeListalta(m)) {
            lista.lisaaLoppuun(m);
        } else {
            System.out.println("Virhe!");
        }
    }

    /**
     * Metodi yritt�� poistaa alkiota listalta sen indeksi numeron perusteella.
     * Metodi tarkistaa indeksin arvon, jos se ei ole sopiva niin tulostetaan
     * virhe ja ei tehd� muutoksia.
     *
     * @param i ei saa olla negatiivinen eik� suurempi kuin listan koko
     */
    public void poista(int i) {
        if (i >= 0 && i < lista.koko()) {
            lista.poista(i);
        } else {
            System.out.println("Virhe!");
        }
    }

    /**
     * Metodi yritt�� t�ytt�� soittolistaa kirjaston medioilla. Jos media on jo
     * listalla tai lista on t�ynn� t�ytt� keskeytyy.
     *
     * @param kirjasto kirjasto
     */
    public void tayta(OmaLista kirjasto) {
        for (int i = 0; i < kirjasto.koko() && lista.koko() < maxkoko; i++) {
            Media m = (Media) kirjasto.alkio(i);

            //Jos havaitaan ett� media on jo listalla herjataan ja lopetetaan.
            if (lista.haeListalta(m)) {
                System.out.println("Virhe!");
                break;
            } else {
                lista.lisaaLoppuun(m);
            }
        }
    }
}
