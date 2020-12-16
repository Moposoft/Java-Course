
/**
 * Abstrakti Media-luokka, joka sisältää medioille yhteiset piirteet.
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public abstract class Media implements Comparable<Media> {

    /**
     * Kaikilla mediolla on nimike.
     */
    private String nimike;

    public String nimike() {
        return nimike;
    }

    public Media(String n) {
        nimike = n;
    }

    /**
     * Korvattu equals metodi tarkistaa onko toisen annetun median nimeke sama
     * kuin oma.
     *
     * @param obj Tarkistettava olio.
     * @return true, jos nimekkeet ovat samat, false jos ei.
     */
    public boolean equals(Object obj) {
        if (obj != null) {
            Media m = (Media) obj;
            return (nimike.equals(m.nimike()));
        } else {
            return false;
        }
    }

    /**
     * Korvattu toString metodi tulostaa median sisällön muotoiltuna jonona.
     * Tulosteeseen kuuluu luokan nimi ja nimike attribuutti.
     */
    public String toString() {
        String luokka = this.getClass().getSimpleName();
        return (Liittyma.muotoile(luokka.length(), 8, luokka)
                + Liittyma.muotoile(nimike().length(), 30, nimike));
    }

    /**
     * Korvattu compareTo metodi vertailee nimikettä toisen median nimikkeeseen.
     * vertailussa käytettään compareToIgnoreCase-metodia.
     *
     * @param m vertailtava media olio.
     */
    public int compareTo(Media m) {
        return nimike.compareToIgnoreCase(m.nimike());
    }
}
