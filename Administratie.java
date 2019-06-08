public class Administratie {

    static final int DAYS_OF_WEEK = 7;

    /**
     * Constructor
     * Niet de bedoeling dat deze wordt gebruikt
     */

    private Administratie() {
    }

    /**
     * Deze methode berekent de gemiddelde waarde van elementen in een double array
     *
     * @param waarden
     * @return het gemiddelde
     */

    public static double berekenGemiddelde(double[] waarden) {
        if (waarden.length == 0) return 0;
        double totaal = 0;
        for (int i = 0; i < waarden.length; i++) {
            totaal += waarden[i];
        }
        return totaal / waarden.length;
    }

    /**
     * Methode om de totale omzet op een bepaalde weekdag uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_OF_WEEK];
        for (int i = 0; i < omzet.length; i++) {
            temp[i % 7] += omzet[i];
        }
        return temp;
    }
}
    /**public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_OF_WEEK];
        for(int i = 0; i < DAYS_OF_WEEK; i++) {
            int j = 0;
            while(omzet[i + 7 * j] < omzet.length) {
                temp[i] += omzet[i + 7 * j];
                j++;
            }
        }
        return temp;
    }
    WHY WON'T THIS WORK??
}
*/