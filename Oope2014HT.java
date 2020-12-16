
/**
 * Main luokka jossa ohjelmalle sy�tet��n komennot ja ne my�s tarkistetaan.
 * <p>
 * Harjoitusty� Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Oope2014HT {

    /**
     * main metodi harjoitusty�lle. Jouduin tekem��n koko k�ytt�liittym�n t�nne.
     * 
     * @param args ei k�yt�ss�.
     */
    public static void main(String[] args) {

        System.out.println("***************");
        System.out.println("* SOITTOLISTA *");
        System.out.println("***************");

        // Tehd��n listat ja annetaan niille tidostojen tiedot.
        Soittolista soittolista = new Soittolista();
        Kirjasto kirjasto = new Kirjasto();
        soittolista.lueTiedosto();
        kirjasto.lueTiedosto();

        String syote;//T�h�n tallennetaan k�ytt�j�n antama sy�te.
        String valinta = "";//Jos sy�te on j�rkev� komento annetaan se t�h�n.
        String[] osa = new String[2];//T�h�n sy�tteen osat jos niit� on.
        int luku = -1; //T�h�n mahdollinen sy�tetty luku.
        boolean lopeta = false; //true jos lopetetaan

        do {
            System.out.println("Kirjoita komento:");

            /*Luetaan k�ytt�j�n sy�te ja tarkistetaan ett� se on j�rkev�. */
            syote = In.readString();

            if (syote.equals("lataa") || syote.equals("tallenna")
                    || syote.equals("kirjasto") || syote.equals("lopeta")
                    || syote.equals("soittolista") || syote.equals("tayta")) {
                valinta = syote;
            }// Jaetaan syote kahtia jos annettu v�lily�nti.
            if (syote.contains(" ")) {
                osa = syote.split(" ", 2);
                if ((osa[0].equals("lisaa") || osa[0].equals("poista")
                        || osa[0].equals("luo")) && Liittyma.onkoLuku(osa[1])) {
                    valinta = osa[0];
                    luku = Integer.parseInt(osa[1]);
                }
                if ((osa[1].equals("laskeva") || osa[1].equals("nouseva"))
                        && osa[0].equals("lajittele")) {
                    valinta = osa[0];
                }
            }

            switch (valinta) {
                case "luo":
                    soittolista.luo(luku, kirjasto.lista.koko());
                    break;
                case "lisaa":
                    soittolista.lisaa((Media) kirjasto.lista.alkio(luku));
                    break;
                case "poista":
                    soittolista.poista(luku);
                    break;
                case "lajittele":
                    kirjasto.lista.lajittele(osa[1]);
                    break;
                case "lataa":
                    soittolista.tyhjenna();
                    soittolista.lueTiedosto();
                    kirjasto.tyhjenna();
                    kirjasto.lueTiedosto();
                    break;
                case "kirjasto":
                    kirjasto.tulostaNaytolle();
                    break;
                case "soittolista":
                    soittolista.tulostaNaytolle();
                    break;
                case "tallenna":
                    soittolista.tallennaTiedosto();
                    kirjasto.tallennaTiedosto();
                    break;
                case "tayta":
                    soittolista.tayta(kirjasto.lista);
                    break;
                case "lopeta":
                    System.out.println("Ohjelma lopetettu.");
                    lopeta = true;
                    break;
                default:
                    System.out.println("Virhe!");
                    break;
            }
            valinta = "";
            luku = -1;
        } while (!lopeta);

    }

}
