import java.math.*;

public class Artikel {

    private String naam;
    private double prijs;

    public Artikel() {
        prijs = 0;
        naam = "Lucht";
    }

    public Artikel(String naam, double prijs) {
        this.prijs = prijs;
        this.naam = naam;
    }

    public String toString() {
        return "Naam: " + this.getNaam() + ", Prijs: €" + this.getPrijs();
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setNaam(String nieuwenaam) {
        naam = nieuwenaam;
    }

    public void setPrijs(double nieuweprijs) {
        prijs = nieuweprijs;
    }

}
