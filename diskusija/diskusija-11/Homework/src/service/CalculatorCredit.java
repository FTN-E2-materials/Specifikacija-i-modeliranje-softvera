package service;

import model.Invoice;
import model.Performance;

public class CalculatorCredit {

    private Integer volumeCredits;
    private Integer credits;

    public CalculatorCredit(){
        volumeCredits = 0;
        credits = 0;
    }

    public int getVolumeCredits(Invoice invoice) {
        for(Performance performance : invoice.performances) {
            volumeCredits += calculateVolumeCredits(performance);
        }
        return volumeCredits;
    }

    public int calculateVolumeCredits(Performance performance) {
        credits = Math.max(performance.audience - 30, 0);
        if ("comedy".equals(performance.play.type))
            credits += Math.max(performance.audience - 60, 0);
        return credits;
    }
}
