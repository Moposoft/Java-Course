
import fi.uta.csjola.oope.lista.*;

/**
 * OmaLista luokka jossa omat listank�sittely metodit
 * <p>
 * Harjoitusty� Olio-ohjelmoinnin perusteet.
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
     * tarkistaan ja luokan omalla equals metodilla tarkistetaan yht�suuruus.
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
     * @param pienin true jos haetaan listan pienint� false jos suurinta
     * @return listan pienimm�n tai suurimman alkion indeksin numero.
     */
    private int valitse(int i, boolean pienin) {

        int luku = i; //L�yetty arvo tallenetaan t�h�n.

        //Vertailaan Listan alkioita indeksi kerrallaan 
        for (int j = i; j < koko(); j++) {
            //Muutetaan listan alkiot media luokan olioksi.
            Media a = (Media) alkio(j);//indeksiolio jota verrataan
            Media b = (Media) alkio(luku);//pienin tai suurin alkio t�h�n

            // Jos hataan pienint� tietoalkiota
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
     * @param j pienimm�n tai suurimman alkion indeksinarvo
     */
    private void vaihda(int i, int j) {
        korvaa(j, korvaa(i, alkio(j)));
    }

    /**
     * Metodi lajittelee listan alkiot joko nousevaan tai laskevaan
     * j�rjestykseen.
     *
     * @param syote nouseva tai laskeva.
     */
    public void lajittele(String syote) {
        boolean b = syote.equals("nouseva");

        int i = 0; // Ensimm�isen lajittelemattoman alkion indeksiarvo. 

        while (i < koko() - 1) {
            // Haetaan pienimm�n tai suurimman tietoalkion indeksinarvo
            // ja asetetaan se muuttujaan j.
            int j = valitse(i, b);
            // Vaihda ensimm�inen lajittelematon alkio
            // ja pienin tai suurin alkio kesken��n.
            vaihda(i, j);
            // Pienin tai suurin alkio on oikeassa paikassa. Suljetaan se pois
            // lajittelusta laskuria kasvattamalla.
            i++;
        }
    }
}
