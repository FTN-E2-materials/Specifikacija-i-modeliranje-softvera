import model.Invoice;
import model.Performance;
import model.Play;
import service.InvoicePrinter;

public class Main {
    public static void main(String[] args) {
        Invoice testInvoice = createTestInvoice();

        InvoicePrinter invoicePrinter = new InvoicePrinter();
        System.out.println(invoicePrinter.printInvoiceStatement(testInvoice));

        //Will print the following text for the testInvoice:
        //Statement for bigCorp
        //  Hamlet: $650.00 (55 seats)
        //  As You Like It: $580.00 (35 seats)
        //  Othello: $500.00 (40 seats)
        //Amount owed is $1730.00
        //You earned 40 credits
    }

    private static Invoice createTestInvoice() {
        Play[] testPlays = new Play[] {
                new Play("Hamlet", "tragedy"),
                new Play("As You Like It", "comedy"),
                new Play("Othello", "tragedy")
        };
        return new Invoice(
                "bigCorp",
                new Performance(testPlays[0], 55),
                new Performance(testPlays[1], 35),
                new Performance(testPlays[2], 40)
        );
    }
}
