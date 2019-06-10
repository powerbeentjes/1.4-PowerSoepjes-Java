import java.math.*;

public abstract class Betaalwijze {

    protected double saldo;

    /**
     * Methode om krediet te initialiseren
     * @param saldo hoogte van het saldo voor de eigenaar van deze betaalwijze
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen prijs die de eigenaar van deze betaalwijze dient te betalen
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;
}