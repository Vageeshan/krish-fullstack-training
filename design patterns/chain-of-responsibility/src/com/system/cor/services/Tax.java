package com.system.cor.services;

import com.system.cor.core.Handler;
import com.system.cor.model.Invoice;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:44 PM Friday
 **/
public class Tax extends Handler {
    @Override
    public double applyTax(Invoice invoice) {
        System.out.println("Tax invoked");
        return successor.applyTax(invoice);
    }
}
