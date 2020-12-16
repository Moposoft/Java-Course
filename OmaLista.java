
import fi.uta.csjola.oope.lista.*;

/**
 * OmaLista luokka jossa omat listankäsittely metodit
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class OmaLista extends LinkitettyLista {

    public OmaLista() {
        super();
    }

    /**
     * Metodilla voi tarkistaa onko tietty Media olio jo listalla. Olion luokka
     * tarkistaan ja luokan omalla equals metodilla tarkistetaan yhtäsuuruus.
     *
     * @param m haettava olio
     * @return true jos listalla, false jos ei.
     */
    public boolean haeListalta(Media m) {
        if (m instanceof Aani) {
            m = (Aani) m;
        } else if (m instanceof Kuva) {
            m = (Kuva) m;
        } else if (m instanceof Video) {
            m = (Video) m;
        }
        if (m != null) {
            for (int i = 0; i < koko(); i++) {
                if (m.equals(alkio(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Haetaan listan pienin tai suurin tietoalkio. Vertailu Media luokan
     * compareTo metodilla.
     *
     * @param i aloitus indeksin arvo
     * @param pienin true jos haetaan listan pienintä false jos suurinta
     * @return listan pienimmän tai suurimman alkion indeksin numero.
     */
    private int valitse(int i, boolean pienin) {

        int luku = i; //Löyetty arvo tallenetaan tähän.

        //Vertailaan Listan alkioita indeksi kerrallaan 
        for (int j = i; j < koko(); j++) {
            //Muutetaan listan alkiot media luokan olioksi.
            Media a = (Media) alkio(j);//indeksiolio jota verrataan
            Media b = (Media) alkio(luku);//pienin tai suurin alkio tähän

            // Jos hataan pienintä tietoalkiota
            if (pienin) {
                if (a.compareTo(b) < 0) {
                    luku = j;
                }
                // Jos haetaankin suurinta
            } else {
                if (a.compareTo(b) > 0) {
                    luku = j;
                }
            }
        }
        return luku;
    }

    /**
     * Metodi vaihtaa kahden annetun alkion paikkaa.
     *
     * @param i lajittelemattoman alkion indeksinarvo
     * @param j pienimmän tai suurimman alkion indeksinarvo
     */
    private void vaihda(int i, int j) {
        korvaa(j, korvaa(i, alkio(j)));
    }

    /**
     * Metodi lajittelee listan alkiot joko nousevaan tai laskevaan
     * järjestykseen.
     *
     * @param syote nouseva tai laskeva.
     */
    public void lajittele(String syote) {
        boolean b = syote.equals("nouseva");

        int i = 0; // Ensimmäisen lajittelemattoman alkion indeksiarvo. 

        while (i < koko() - 1) {
            // Haetaan pienimmän tai suurimman tietoalkion indeksinarvo
            // ja asetetaan se muuttujaan j.
            int j = valitse(i, b);
            // Vaihda ensimmäinen lajittelematon alkio
            // ja pienin tai suurin alkio keskenään.
            vaihda(i, j);
            // Pienin tai suurin alkio on oikeassa paikassa. Suljetaan se pois
            // lajittelusta laskuria kasvattamalla.
            i++;
        }
    }
}
