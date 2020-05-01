<h1 align = "center"> 11. Cist dizajn koda </h1>

[Domaci projekat](https://github.com/vlaksi/Specifikacija-i-modeliranje-softvera/tree/master/diskusija/diskusija-11/Homework/src) smo podelili u tri paketa:
  - ***model***: Osnovni model podataka, slican beans-ima i POJO klasama.
  - ***dto***: Obicne strukture podataka koje cemo prenositi kao parametre kroz neku metodu kako bismo ispegli gomilanje parametara.
  - ***service***: Objekti koji vrsi poslovnu logiku.

Testiranje nije automatizovano, ali se pokretanjem klase Main vrsi osnovno testiranje.

### Materijal 
  - [predavanja 1](https://github.com/vlaksi/Specifikacija-i-modeliranje-softvera/blob/master/Predavanja/SIMS%20-%2008%20-%20Čist%20dizajn%20koda%20I.pdf)
  - [predavanja 2](https://github.com/vlaksi/Specifikacija-i-modeliranje-softvera/blob/master/Predavanja/SIMS%20-%2009%20-%20Čist%20dizajn%20koda%20II.pdf)
  - [IntelliJ IDEA](https://www.youtube.com/watch?v=S_GLO5la_nI)

  
### Radili
  - [Igor Roncevic](https://github.com/igorroncevic)
  - [Filip Zukovic](https://github.com/zukovicfilip)
  - [Nemanja Pualic](https://github.com/Pufke)
  - [Vladislav Maksimovic](https://github.com/vlaksi)


### Potrebno refaktorisati:

```sh
public class Play {
    public String name;
    public String type;
 
    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
 
public class Performance {
    public Play play;
    public int audience;
 
    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }
}
 
public class Invoice {
    public String customer;
    public Performance[] performances;
 
    public Invoice(String customer, Performance ... performances) {
        this.customer = customer;
        this.performances = performances;
    }
}
 
public class PerformanceInvoiceCalculator3 {
    public String printInvoiceStatement(Invoice invoice) {
        String result = String.format("Statement for %s%n", invoice.customer);
        for (Performance performance : invoice.performances) {
            String performanceStatement = String.format("  %s: $%.2f (%d seats)%n", performance.play.name, calculatePerformancePrice(performance)/100, performance.audience);
            result += performanceStatement;
        }
        result += String.format("Amount owed is $%.2f%n", getTotalAmount(invoice)/100);
        result += String.format("You earned %d credits%n", getVolumeCredits(invoice));
        return result;
    }
 
    private double getTotalAmount(Invoice invoice) {
        double totalAmount = 0;
        for (Performance performance : invoice.performances) {
            totalAmount += calculatePerformancePrice(performance);
        }
        return totalAmount;
    }
 
    private double calculatePerformancePrice(Performance performance) {
        double thisAmount = 0;
        switch (performance.play.type) {
            case "tragedy":
                thisAmount = 40000;
                if (performance.audience > 30) {
                    thisAmount += 1000 * (performance.audience - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (performance.audience > 20) {
                    thisAmount += 10000 + 500 * (performance.audience - 20);
                }
                thisAmount += 300 * performance.audience;
                break;
            default:
                throw new Error(String.format("unknown type: %s%n", performance.play.type));
        }
        return thisAmount;
    }
 
    private int getVolumeCredits(Invoice invoice) {
        int volumeCredits = 0;
        for(Performance performance : invoice.performances) {
            volumeCredits += calculateVolumeCredits(performance);
        }
        return volumeCredits;
    }
 
    private int calculateVolumeCredits(Performance performance) {
        int volumeCredits = Math.max(performance.audience - 30, 0);
        if ("comedy".equals(performance.play.type))
            volumeCredits += Math.max(performance.audience - 60, 0);
        return volumeCredits;
    }
}

```
