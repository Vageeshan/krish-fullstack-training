package com.system.cor.services;

import com.system.cor.core.Handler;
import com.system.cor.model.Invoice;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:42 PM Friday
 **/
public class SSF extends Handler {
    @Override
    public double applyTax(Invoice invoice) {
        invoice.setTax(invoice.getTax() + invoice.getAmount() * 0.04);
        System.out.println("SSF Invoked");
        return invoice.getTax();
    }
}
