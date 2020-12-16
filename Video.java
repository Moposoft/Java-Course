
/**
 * Video luokka
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Video extends Media {

    private String tyylilaji;

    public String tyylilaji() {
        return tyylilaji;
    }

    public Video(String n, String t) {
        super(n);
        tyylilaji = t;
    }

    /**
     * Korvattu equals metodi tarkistaa ovatko toisen annetun olion tyylilaji ja
     * yliluokan atribuutti samat kuin omat.
     *
     * @param obj Tarkistettava olio.
     * @return true, jos tyylilajit sekä yliluokan nimikearvot ovat
     * samanarvoiset, false jos ei tai jos vertailtava ei ole Video.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Video) {
            Video v = (Video) obj;
            return (super.equals(obj) && tyylilaji().equals(v.tyylilaji()));
        }
        return false;
    }

    /**
     * Korvattu toString metodi tulostaa yliluokan sisällön sekä tyylilaji
     * attribuutin arvon muotoiltuna jonona.
     */
    public String toString() {
        int jononpituus = tyylilaji().length();
        return super.toString() + Liittyma.muotoile(jononpituus, 8, tyylilaji);
    }
}
