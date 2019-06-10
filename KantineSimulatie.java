import java.util.*;
import java.math.*;

public class KantineSimulatie {

    private Kantine kantine;
    private Datum datum;
    private static final String[] DAGNAMEN = new String[]{"Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag", "Zondag"};
    private KantineAanbod aanbod;
    private Random random;
    private Persoon klant;
    private double[] klantenarray;
    private double[] artikelenarray;
    private double[] omzetarray;
    private static final String[] artikelnamen = new String[]{"Soepie", "Crostini", "Supersoepie", "Melk"};
    private static double[] artikelprijzen = new double[]{1.50,2.00,5.55,0.88};
    private static final String outputdivider = "============================================================================================";
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;
    private static final int MIN_PERSONEN_PER_DAG = 5;
    private static final int MAX_PERSONEN_PER_DAG = 20;
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    public static final int DAGEN = 10;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        datum = new Datum(1, 1, 1990);
        random = new Random();
        klantenarray = new double[DAGEN];
        artikelenarray = new double[DAGEN];
        omzetarray = new double[DAGEN];
        int[] hoeveelheden = getRandomArray(
                artikelnamen.length,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        aanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setAanbod(aanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte lengte van de te genereren array
     * @param min minimale waarde van elementen in de array
     * @param max maximale waarde van elementen in de array
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min minimale waarde van het te genereren getal
     * @param max maximale waarde van het te genereren getal
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen de array met indexnummers van artikelen
     * @return De array met de artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen het aantal dagen dat gesimuleerd dient te worden
     */
    public void simuleer(int dagen) {

        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for (int p = 0; p < aantalpersonen; p++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt

                int typeklant = random.nextInt(100);

                if (typeklant < 90) klant = new Student();
                else if (typeklant < 100) klant = new Docent();
                else klant = new KantineMedewerker();
                Dienblad dienblad = new Dienblad(klant);

                System.out.println(klant.toString());

                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, artikelnamen.length - 1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan

                loopPakSluitAan(dienblad, artikelen);

            }

            kantine.verwerkRijVoorKassa();
            System.out.println(outputdivider);
            if (i % 7 == 0) {
                System.out.println("   WEEK #" + (i / 7 + 1));
                System.out.println(outputdivider);
            }
            System.out.println("DAGTOTAAL " + datum.getDatumAsString() + ", " + DAGNAMEN[i % 7]);
            System.out.println("Aantal klanten: " + kantine.getKassa().getAantalKlanten());
            klantenarray[i] = kantine.getKassa().getAantalKlanten();
            System.out.println("Aantal artikelen verkocht: " + kantine.getKassa().getAantalArtikelen());
            artikelenarray[i] = kantine.getKassa().getAantalArtikelen();
            System.out.println("Geld verdiend: €" + String.format("%.2f" ,kantine.getKassa().hoeveelheidGeldInKassa()));
            omzetarray[i] = kantine.getKassa().hoeveelheidGeldInKassa();

            kantine.getKassa().resetKassa();
            datum.volgendeDag();

        }
        System.out.println(outputdivider);
        System.out.println("Simulatie van " + DAGEN + " dagen voltooid");
        System.out.println("Gemiddeld aantal klanten: " + String.format("%.1f" ,Administratie.berekenGemiddelde(klantenarray)));
        System.out.println("Gemiddelde omzet: €" + String.format("%.2f" ,Administratie.berekenGemiddelde(omzetarray)));
        System.out.println("Gemiddeld aantal artikelen: " + String.format("%.1f" ,Administratie.berekenGemiddelde(artikelenarray)));

        double[] dagomzet = Administratie.berekenDagOmzet(omzetarray);
        System.out.println("Totaalomzet per weekdag:");
        System.out.println("MAANDAG   €" + String.format("%.2f" ,dagomzet[0]));
        System.out.println("DINSDAG   €" + String.format("%.2f" ,dagomzet[1]));
        System.out.println("WOENSDAG  €" + String.format("%.2f" ,dagomzet[2]));
        System.out.println("DONDERDAG €" + String.format("%.2f" ,dagomzet[3]));
        System.out.println("VRIJDAG   €" + String.format("%.2f" ,dagomzet[4]));
        System.out.println("ZATERDAG  €" + String.format("%.2f" ,dagomzet[5]));
        System.out.println("ZONDAG    €" + String.format("%.2f" ,dagomzet[6]));

    }

    /**
     * In deze methode selecteert een Persoon met een dienblad willekeurig
     * artikelen uit de array artikelnamen, plaatst deze op het dienblad en sluit vervolgens achteraan.
     *
     * @param dienblad het dienblad waarop de artikelen worden geplaatst
     * @param artikelnamen de gekozen artikelen die uit het aanbod moeten worden opgehaald
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {

        for (String artikelnaam : artikelnamen) {
            dienblad.voegToe(aanbod.getArtikel(artikelnaam));
        }

        kantine.getKassarij().sluitAchteraan(dienblad);
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        double gemiddelde = Administratie.berekenGemiddelde(new double[]{});
        System.out.println(""+gemiddelde);

        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        KantineSimulatie kantinesimulatie = new KantineSimulatie();

        kantinesimulatie.simuleer(dagen);
    }
}