import java.math.*;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen De totaal te betalen prijs.
     * @throws TeWeinigGeldException Als de klant niet genoeg geld heeft.
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (saldo - tebetalen < 0) {
            throw new TeWeinigGeldException("Klant kon niet betalen: ");
        }
        saldo -= tebetalen;
    }
}