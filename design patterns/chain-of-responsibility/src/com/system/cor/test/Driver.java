package com.system.cor.test;

import com.system.cor.model.Invoice;
import com.system.cor.services.*;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 02:47 PM Friday
 * reference https://www.youtube.com/watch?v=iOOnctEDp84&list=PLD-mYtebG3X86i3uyAXwZKfVtUy2gMDdo&index=5
 **/
public class Driver {
    public static void main(String[] args) {
        Tax tax = new Tax();
        VAT vat = new VAT();
        NBT nbt = new NBT();
        BTT btt = new BTT();
        SSF ssf = new SSF();

        tax.setSuccessor(vat);
        vat.setSuccessor(nbt);
        nbt.setSuccessor(btt);
        btt.setSuccessor(ssf);

        Invoice invoice1 = new Invoice(1, 40);
        System.out.println(tax.applyTax(invoice1));

        Invoice invoice2 = new Invoice(2, 120);
        System.out.println(tax.applyTax(invoice2));

        Invoice invoice3 = new Invoice(3, 250);
        System.out.println(tax.applyTax(invoice3));

        Invoice invoice4 = new Invoice(4, 350);
        System.out.println(tax.applyTax(invoice4));

        Invoice invoice5 = new Invoice(5, 450);
        System.out.println(tax.applyTax(invoice5));

        Invoice invoice6 = new Invoice(6, 550);
        System.out.println(tax.applyTax(invoice6));
    }
}
