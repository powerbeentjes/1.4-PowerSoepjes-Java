import java.util.Iterator;
import java.util.Stack;
import java.math.*;


public class Kassa {

    private KassaRij kassarij;
    private int aantalklanten;
    private int aantalartikelen;
    private double geld;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
        resetKassa();
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param dienblad die moet afrekenen
     */
    public void rekenAf(Dienblad dienblad) {
        aantalklanten++;
        aantalartikelen += getAantalArtikelenOpDienblad(dienblad);
        geld += getTotaalPrijs(dienblad);
        kassarij.naarVolgendeKlant();
    }

    public int getAantalKlanten() {
        return aantalklanten;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */

    public int getAantalArtikelen() {
        return aantalartikelen;
    }

    /**
     * Methode om aantal WERKELIJKE artikelen op dienblad te tellen
     * Trekt het aantal Lucht-artikelen (geselecteerde artikelen waar geen voorraad van was) af van het totaal
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelenOpDienblad(Dienblad dienblad) {
        int hoeveelheidlucht = 0;
        for (int i = 0; i < dienblad.getArtikelen().size(); i++) {
            if (dienblad.getArtikelen().get(i).getNaam() == "Lucht") hoeveelheidlucht++;
        }
        return dienblad.getArtikelen().size() - hoeveelheidlucht;
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs(Dienblad dienblad) {
        double total = 0;
        while(!dienblad.getArtikelen().empty()) {
            total += dienblad.getArtikelen().peek().getPrijs();
            dienblad.getArtikelen().pop();
        }
        return total;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geld;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        aantalklanten = 0;
        aantalartikelen = 0;
        geld = 0;
    }

    public KassaRij getKassarij() {
        return kassarij;
    }
}