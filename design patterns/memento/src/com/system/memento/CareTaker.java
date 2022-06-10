package com.system.memento;

import java.util.Stack;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 03:43 PM Friday
 **/
public class CareTaker {
    Stack<Cart.CartMemento> history = new Stack<>();

    public void save(Cart cart) {
        history.push(cart.save());
    }

    public void revert(Cart cart) {
        if (!history.isEmpty())
            cart.revert(history.pop());
        else
            System.out.println("Cannot undo");
    }
}
