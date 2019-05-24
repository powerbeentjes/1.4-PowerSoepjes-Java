public class Persoon {

    private String bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;

    public Persoon() {
        this.bsn = "Onbekend";
        this.voornaam = "Onbekend";
        this.achternaam = "Onbekend";
        this.geboortedatum = new Datum();
        this.geslacht = 'x';
    }

    public Persoon(String bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
        this.setBsn(bsn);
        this.setVoornaam(voornaam);
        this.setAchternaam(achternaam);
        this.setGeboortedatum(geboortedatum);
        this.setGeslacht(geslacht);
    }

    public String toString() {
        return "BSN: " + this.getBsn() + ", Voornaam: " + this.getVoornaam() + ", Achternaam: " + this.getAchternaam() + ", Geboortedatum: " + this.getGeboortedatum() + ", Geslacht: " + this.getGeslacht();
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

    public void setGeslacht(char geslacht) {
        if(geslacht == 'm' | geslacht == 'v') {
            this.geslacht = geslacht;
        } else {
            System.out.println("Ongeldig geslacht: kies tussen v en m.");
            this.geslacht = 'x';
        }
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
        String gds = geboortedatum.getDatumAsString();
        return gds;
    }

    public String getGeslacht() {
        if (geslacht == 'v') return "Vrouw";
        if (geslacht == 'm') return "Man";
        return "Onbekend";
    }
}