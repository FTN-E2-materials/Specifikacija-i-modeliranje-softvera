package service;

import dto.MessageOfInvoice;
import model.Performance;

public class Formater {

    private String format;

    public Formater(){
        format = "";
    }

    public String formatThisMessageOfInvoice(MessageOfInvoice messageOfInvoice){
        messageOfInvoice.message.append(String.format("Statement for %s%n", messageOfInvoice.invoice.customer));

        CalculatorAmount calculatorAmount = new CalculatorAmount();
        CalculatorCredit calculatorCredit = new CalculatorCredit();

        for (Performance performance : messageOfInvoice.invoice.performances) {
            messageOfInvoice.message.append(String.format("  %s: $%.2f (%d seats)%n", performance.play.name, calculatorAmount.calculatePerformancePrice(performance) / 100, performance.audience));
        }

        messageOfInvoice.message.append(String.format("Amount owed is $%.2f%n", calculatorAmount.getTotalAmount(messageOfInvoice.invoice)/100));
        messageOfInvoice.message.append(String.format("You earned %d credits%n", calculatorCredit.getVolumeCredits(messageOfInvoice.invoice)));

        format = messageOfInvoice.message.toString();
        return format;
    }
}
