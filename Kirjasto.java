
import java.io.*;

/**
 * Kirjasto luokka kirjaston k�sittelyyn.
 * <p>
 * Harjoitusty� Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Kirjasto extends MediaLista {

    /**
     * Kirjasto tiedoston nimi vakiona.
     */
    private final File tiedosto = new File("kirjasto.txt");

    /**
     * Kuormitin yliluokan metodin niin, ett� se saa tiedoston nimen suoraan
     * vakiosta.
     */
    public void lueTiedosto() {
        super.lueTiedosto(tiedosto);
    }

    /**
     * Kuormitin yliluokan metodin niin, ett� se saa tiedoston nimen suoraan
     * vakiosta.
     */
    public void tallennaTiedosto() {
        super.tallennaTiedosto(tiedosto);
    }

}
