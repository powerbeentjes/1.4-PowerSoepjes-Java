public class KantineMedewerker extends Persoon implements KortingskaartHouder {

    private int nummer;
    private boolean magachterkassa;

    public KantineMedewerker() {
        super();
        nummer = 0;
        magachterkassa = false;
        type = "KantineMedewerker";
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    public double geefKortingsPercentage() {
        return 0.35;
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    public boolean heeftMaximum() {
        return false;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    public double geefMaximum() {
        return 1;
    }

}