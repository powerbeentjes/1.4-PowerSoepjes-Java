public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod aanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan() {
        Persoon klant = new Persoon();
        Dienblad dienblad = new Dienblad();
        dienblad.setKlant(klant);
        Artikel crostini = new Artikel("Crostini",1);
        Artikel soepie = new Artikel("Soepie",1);
        dienblad.voegToe(crostini);
        dienblad.voegToe(soepie);
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    public Kassa getKassa() {
        return kassa;
    }

    public KantineAanbod getAanbod() {
        return aanbod;
    }

    public void setAanbod(KantineAanbod aanbod) {
        this.aanbod = aanbod;
    }
}