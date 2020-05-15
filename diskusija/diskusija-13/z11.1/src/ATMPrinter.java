public class ATMPrinter {

    public void printBalanceStatement(Account account) {

        printHeader(account);
        printFees(account);
        printBalance(account);

    }

    private void printHeader(Account account) {
        printPattern("Debits",account.debits);
        printPattern("Credits",account.credits);
    }

    private void printFees(Account account) {
        printPattern("Fees", account.fees);
        System.out.println("   ----------------");
    }

    private void printBalance(Account account) {
        printPattern("Balance",account.balance);
    }

    /*
        Napomena: printingPattern nije morao mozda da postoji, ali zbog zelje
        da sve bude na istom nivou apstrakcije ostavljam ipak metodu.

        Samim tim kasnije patern stampanja moze kasnije da se promeni.
     */
    private void printPattern(String nameOfPrintingState, Double state){
        StringBuilder formatPart = formatting(nameOfPrintingState, state);
        Double stateForPrinting = getStateForPrinting(state);
        printingPattern(nameOfPrintingState, stateForPrinting, formatPart.toString());
    }

    private StringBuilder formatting(String nameOfPrintingState, Double state) {
        StringBuilder formatPart = new StringBuilder();
        formatPart.append(": %10.2f");

        if (state < 0){
            if(nameOfPrintingState.toLowerCase().equals("fees")){
                formatPart.append("-\n");
            }else if(nameOfPrintingState.toLowerCase().equals("balance")){
                formatPart.append("\n-");
            }
        }else{
            formatPart.append("\n");
        }
        return formatPart;
    }

    /*
        Nisam siguran da li sam dobro razumeo ovaj deo http://prntscr.com/shiw2u
        da li to znaci da mu on zapravo da minus ili nesto oko formatiranja.

        Ja sam uradio kao da je u pitanju minus, pa je potrebno samo negativan broj
        prebaciti u pozitivan.
     */
    private double getStateForPrinting(Double state){
        if (state<0){
            state *= -1;
        }
        return state;
    }

    private void printingPattern(String nameOfPrintingState, Double state, String formatPart) {
        System.out.format(nameOfPrintingState + formatPart,state);
    }
}
