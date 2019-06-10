import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    private LinkedList<Dienblad> rij;

    /**
     * Constructor
     */
    public KassaRij() {
        rij = new LinkedList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param dienblad
     */
    public void sluitAchteraan(Dienblad dienblad) {
        rij.add(dienblad);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        return rij.getFirst();
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return !rij.isEmpty();
    }

    public void naarVolgendeKlant() {
        rij.remove();
    }
}