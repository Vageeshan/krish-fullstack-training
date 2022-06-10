package com.system.cor.services;

import com.system.cor.core.Handler;
import com.system.cor.model.Invoice;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:41 PM Friday
 **/
public class NBT extends Handler {
    /**
     * @param invoice
     * @return
     */
    @Override
    public double applyTax(Invoice invoice) {
        invoice.setTax(invoice.getTax() + invoice.getAmount() * 0.02);
        System.out.println("NBT Invoked");
        if (invoice.getAmount() > 100.0 && invoice.getAmount() <= 200.0) {
            System.out.println("NBT Inside the if");
            return invoice.getTax();
        } else {
            System.out.println("NBT Something wrong...");
            return successor.applyTax(invoice);
        }
    }
}
