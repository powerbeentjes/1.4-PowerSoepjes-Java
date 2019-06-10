import java.math.*;

public interface KortingskaartHouder {

    /**
     * Methode om kortingspercentage op te vragen
     */
    double geefKortingsPercentage();

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    boolean heeftMaximum();

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    double geefMaximum();

}