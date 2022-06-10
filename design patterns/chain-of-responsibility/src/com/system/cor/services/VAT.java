package com.system.cor.services;

import com.system.cor.core.Handler;
import com.system.cor.model.Invoice;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:45 PM Friday
 **/
public class VAT extends Handler {
    /**
     * @param invoice
     * @return
     */
    @Override
    public double applyTax(Invoice invoice) {
        invoice.setTax(invoice.getTax() + invoice.getAmount() * 0.01);
        System.out.println("Vat Invoked");
        if (invoice.getAmount() <= 100) {
            return invoice.getTax();
        } else {
            return successor.applyTax(invoice);
        }
    }
}
