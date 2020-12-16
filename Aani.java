
/**
 * Aani luokka
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Aani extends Media {

    private int pituus;

    public int pituus() {
        return pituus;
    }

    public Aani(String n, int p) {
        super(n);
        pituus = p;
    }

    /**
     * Korvattu equals metodi tarkistaa ovatko toisen annetun olion pituus ja
     * yliluokan atribuutti samat kuin omat.
     *
     * @param obj Tarkistettava olio.
     * @return true, jos pituudet sekä yliluokan nimikearvot ovat samanarvoiset,
     * false jos ei tai jos vertailtava ei ole Aani.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Aani) {
            Aani a = (Aani) obj;
            return (super.equals(obj) && pituus() == a.pituus());
        }
        return false;
    }

    /**
     * Korvattu toString metodi tulostaa yliluokan sisällön sekä pituus
     * attribuutin arvon muotoiltuna jonona.
     */
    public String toString() {
        int jononpituus = String.valueOf(pituus).length();
        return super.toString() + Liittyma.muotoile(jononpituus, 8, pituus);
    }
}
