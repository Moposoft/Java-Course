
/**
 * Liittymä luokkan oli tarkoitus olla koko käyttöliittymän tekevä luokka. 
 * Nyt siinä on vain muutama julkinen luokkametodi, joita tarvitaan muualla.
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public abstract class Liittyma {

    /**
     * Metodilla muotoillaan tietue kentät tulostettavaan muotoon.
     *
     * @param jononpituus Merkkijonon tai luvun pituus ts. montako
     * kirjainta/lukua
     * @param kentankoko Tietue kentät ovat eri kokoisia.
     * @param tieto Itse tulostettava tieto.
     * @return muotoiltu merkkijono.
     */
    public static String muotoile(int jononpituus, int kentankoko, Object tieto) {
        String tayte = "";
        String tyhja = " ";
        String reuna = "|";
        for (int i = jononpituus; i < kentankoko; i++) {
            tayte += tyhja;
        }
        return tieto + tayte + reuna;
    }

    /**
     * Yksinkertainen apumetodi joka tarkistaa onko merkkijonon muuttaminen
     * kokonaisluvuksi mahdollista.
     *
     * @param s Tarkistettava merkkijono.
     * @return true, jos jonon muutto on mahdollista, false jos ei.
     */
    public static boolean onkoLuku(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
