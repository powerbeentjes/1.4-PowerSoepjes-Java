public class Docent extends Persoon {

    private String vierlettercode;
    private String afdeling;

    public Docent() {
        super();
        vierlettercode = "____";
        afdeling = "Onbekend";
        type = "Docent";
    }

    public String getVierlettercode() {
        return vierlettercode;
    }

    public void setVierlettercode(String vierlettercode) {
        this.vierlettercode = vierlettercode;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}