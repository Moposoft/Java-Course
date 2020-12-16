
/**
 * Main luokka jossa ohjelmalle syötetään komennot ja ne myös tarkistetaan.
 * <p>
 * Harjoitustyö Olio-ohjelmoinnin perusteet.
 * <p>
 * @version Viimeksi muutettu 25.3.2014.
 * <p>
 * @author Petri Kaukopuro (petri.kaukopuro@uta.fi)
 */
public class Oope2014HT {

    /**
     * main metodi harjoitustyölle. Jouduin tekemään koko käyttöliittymän tänne.
     * 
     * @param args ei käytössä.
     */
    public static void main(String[] args) {

        System.out.println("***************");
        System.out.println("* SOITTOLISTA *");
        System.out.println("***************");

        // Tehdään listat ja annetaan niille tidostojen tiedot.
        Soittolista soittolista = new Soittolista();
        Kirjasto kirjasto = new Kirjasto();
        soittolista.lueTiedosto();
        kirjasto.lueTiedosto();

        String syote;//Tähän tallennetaan käyttäjän antama syöte.
        String valinta = "";//Jos syöte on järkevä komento annetaan se tähän.
        String[] osa = new String[2];//Tähän syötteen osat jos niitä on.
        int luku = -1; //Tähän mahdollinen syötetty luku.
        boolean lopeta = false; //true jos lopetetaan

        do {
            System.out.println("Kirjoita komento:");

            /*Luetaan käyttäjän syöte ja tarkistetaan että se on järkevä. */
            syote = In.readString();

            if (syote.equals("lataa") || syote.equals("tallenna")
                    || syote.equals("kirjasto") || syote.equals("lopeta")
                    || syote.equals("soittolista") || syote.equals("tayta")) {
                valinta = syote;
            }// Jaetaan syote kahtia jos annettu välilyönti.
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
