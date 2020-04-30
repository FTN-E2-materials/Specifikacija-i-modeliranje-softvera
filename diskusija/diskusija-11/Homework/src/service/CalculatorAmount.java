package service;

import model.Invoice;
import model.Performance;

public class CalculatorAmount {

    private Integer perfomancePrice;
    private Double totalAmount;

    public CalculatorAmount(){
        this.perfomancePrice=0;
        this.totalAmount =0.0;
    }

    public double calculatePerformancePrice(Performance performance) {
        switch (performance.play.type) {
            case "tragedy":
                perfomancePrice = 40000;
                if (performance.audience > 30) {
                    perfomancePrice += 1000 * (performance.audience - 30);
                }
                break;
            case "comedy":
                perfomancePrice = 30000;
                if (performance.audience > 20) {
                    perfomancePrice += 10000 + 500 * (performance.audience - 20);
                }
                perfomancePrice += 300 * performance.audience;
                break;
            default:
                throw new Error(String.format("unknown type: %s%n", performance.play.type));
        }
        return perfomancePrice;
    }

    public double getTotalAmount(Invoice invoice) {
        for (Performance performance : invoice.performances) {
            totalAmount += calculatePerformancePrice(performance);
        }
        return totalAmount;
    }


}
