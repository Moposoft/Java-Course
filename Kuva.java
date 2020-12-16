
/**
 * Kuva luokka
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Kuva extends Media {

    /**
     * True jos bittikartta
     */
    private boolean bittikartta;

    public boolean bittikartta() {
        return bittikartta;
    }

    public Kuva(String n, boolean b) {
        super(n);
        bittikartta = b;
    }

    /**
     * Korvattu equals metodi tarkistaa ovatko toisen annetun olion bittikartta
     * ja yliluokan atribuutti samat kuin omat.
     *
     * @param obj Tarkistettava olio.
     * @return true, jos bittikarttat sekä yliluokan nimikearvot ovat
     * samanarvoiset, false jos ei tai jos vertailtava ei ole Kuva.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Kuva) {
            Kuva k = (Kuva) obj;
            return (super.equals(obj) && bittikartta() == k.bittikartta());
        }
        return false;
    }

    /**
     * Korvattu toString metodi tulostaa yliluokan sisällön sekä bittikartta
     * attribuutin arvon muotoiltuna jonona.
     */
    public String toString() {
        if (bittikartta) {
            return super.toString() + Liittyma.muotoile(4, 8, bittikartta);
        } else {
            return super.toString() + Liittyma.muotoile(5, 8, bittikartta);
        }
    }

}
