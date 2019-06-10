public abstract class Persoon {

    enum Geslacht {MAN,VROUW}

    private String bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private Geslacht geslacht;
    private Betaalwijze betaalwijze;
    protected String type;

    public Persoon() {
        this.bsn = "Onbekend";
        this.voornaam = "Onbekend";
        this.achternaam = "Onbekend";
        this.geboortedatum = new Datum();
        this.type = "geen";
        this.betaalwijze = new Contant();
        this.betaalwijze.setSaldo(10);
    }

    public Persoon(String bsn, String voornaam, String achternaam, Datum geboortedatum, Geslacht geslacht) {
        this();
        this.setBsn(bsn);
        this.setVoornaam(voornaam);
        this.setAchternaam(achternaam);
        this.setGeboortedatum(geboortedatum);
        this.setGeslacht(geslacht);
    }

    public String toString() {
        return "Type klant: " + this.getType() + ", BSN: " + this.getBsn() + ", Voornaam: " + this.getVoornaam() + ", Achternaam: " + this.getAchternaam() + ", Geboortedatum: " + this.getGeboortedatum() + ", Geslacht: " + this.getGeslacht();
    }

    public String getType() {
        return type;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(Geslacht geslacht) {
            this.geslacht = geslacht;
    }

    public String getBsn() {
        return bsn;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString();
    }

    public String getGeslacht() {
        if (geslacht == null) return "Onbekend";
        if (geslacht == Geslacht.MAN) return "Man";
        return "Man";
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }
}
