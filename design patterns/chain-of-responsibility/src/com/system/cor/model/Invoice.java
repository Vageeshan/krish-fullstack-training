package com.system.cor.model;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:39 PM Friday
 **/
public class Invoice {
    private int invoiceNumber;
    private double amount;
    private double tax;

    public Invoice(int invoiceNumber, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
