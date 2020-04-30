package model;

public class Invoice {
    public String customer;
    public Performance[] performances;

    public Invoice(String customer, Performance ... performances) {
        this.customer = customer;
        this.performances = performances;
    }
}
