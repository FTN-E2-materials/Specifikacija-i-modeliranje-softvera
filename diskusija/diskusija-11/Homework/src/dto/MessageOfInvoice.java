package dto;

import model.Invoice;

public class MessageOfInvoice {
    public StringBuilder message;
    public Invoice invoice;

    public MessageOfInvoice(Invoice invoice){
        this.message = new StringBuilder();
        this.invoice = invoice;
    }
}
