package com.system.cor.core;

import com.system.cor.model.Invoice;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:39 PM Friday
 **/
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract double applyTax(Invoice invoice);
}
