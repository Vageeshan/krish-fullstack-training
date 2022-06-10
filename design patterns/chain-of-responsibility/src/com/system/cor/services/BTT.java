package com.system.cor.services;

import com.system.cor.core.Handler;
import com.system.cor.model.Invoice;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:38 PM Friday
 **/
public class BTT extends Handler {

    @Override
    public double applyTax(Invoice invoice) {
        invoice.setTax(invoice.getTax() + invoice.getAmount() * 0.03);
        System.out.println("BTT Invoked");

        if (invoice.getAmount() > 200.0 && invoice.getAmount() <= 300.0) {
            return invoice.getTax();
        } else {
            System.out.println("BIT else");
            return successor.applyTax(invoice);
        }
    }
}
