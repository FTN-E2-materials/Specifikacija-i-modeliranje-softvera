import dto.Invoice;
import dto.Performance;

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
