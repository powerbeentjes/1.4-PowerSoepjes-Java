import java.math.*;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet de maximale hoeveelheid geld die de eigenaar van de betaalwijze rood mag staan
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen De totaal te betalen prijs.
     * @throws TeWeinigGeldException Als de klant niet genoeg geld heeft.
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (saldo - tebetalen < kredietlimiet) {
            throw new TeWeinigGeldException("Klant kon niet betalen: ");
        }
        saldo -= tebetalen;
    }
}
