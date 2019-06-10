public class Docent extends Persoon implements KortingskaartHouder {

    private String vierlettercode;
    private String afdeling;

    public Docent() {
        super();
        vierlettercode = "____";
        afdeling = "Onbekend";
        type = "Docent";
    }

    public String getVierlettercode() {
        return vierlettercode;
    }

    public void setVierlettercode(String vierlettercode) {
        this.vierlettercode = vierlettercode;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    public double geefKortingsPercentage() {
        return 0.25;
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    public boolean heeftMaximum() {
        return true;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    public double geefMaximum() {
        return 1;
    }
}