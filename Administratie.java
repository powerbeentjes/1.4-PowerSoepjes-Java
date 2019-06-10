public abstract class Administratie {

    static final int DAYS_OF_WEEK = 7;

    /**
     * Deze methode berekent de gemiddelde waarde van elementen in een double array
     *
     * @param waarden array van waarden
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
     * @param omzet array met de omzet van elke dag in de simulatie, op volgorde.
     * @return array (7 elementen) met dagomzetten.
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_OF_WEEK];
        for (int i = 0; i < omzet.length; i++) {
            temp[i % 7] += omzet[i];
        }
        return temp;
    }
}