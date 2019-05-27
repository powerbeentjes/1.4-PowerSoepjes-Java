import java.math.*;

public class Artikel {

    private String naam;
    private BigDecimal prijs;

    public Artikel() {
        prijs = new BigDecimal(0).setScale(2,RoundingMode.HALF_UP);
        naam = "Lucht";
    }

    public Artikel(String naam, BigDecimal prijs) {
        this.prijs = prijs;
        this.naam = naam;
    }

    public String toString() {
        return "Naam: " + this.getNaam() + ", Prijs: €" + this.getPrijs();
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setNaam(String nieuwenaam) {
        naam = nieuwenaam;
    }

    public void setPrijs(BigDecimal nieuweprijs) {
        prijs = nieuweprijs;
    }

}
