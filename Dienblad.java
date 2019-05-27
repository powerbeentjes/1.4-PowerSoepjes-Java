import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructors
     */
    public Dienblad() {
        artikelen = new Stack<>();
    }

    public Dienblad(Persoon klant) {
        this();
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel Het artikel.
     */
    public void voegToe(Artikel artikel) {
        artikelen.push(artikel);
    }

    public Persoon getKlant() {
        return klant;
    }

    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

