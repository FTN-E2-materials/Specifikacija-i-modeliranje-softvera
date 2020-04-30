package service;

import dto.MessageOfInvoice;
import model.Invoice;

public class InvoicePrinter {

    private String outputMessage;

    public InvoicePrinter(){
        outputMessage = "";
    }


    public String printInvoiceStatement(Invoice invoice){
        Formater formater = new Formater();
        MessageOfInvoice messageForFormating = new MessageOfInvoice(invoice);

        outputMessage = formater.formatThisMessageOfInvoice(messageForFormating);
        return outputMessage;
    }
}
