package com.system.memento;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 03:43 PM Friday
 * reference https://www.youtube.com/watch?v=Pwm-jrG2ZVA&list=PLD-mYtebG3X86i3uyAXwZKfVtUy2gMDdo&index=6
 **/
public class Test {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Cart cart = new Cart();

        cart.addItem(new Item("Mouse"));
        cart.addItem(new Item("Keyboard"));
        careTaker.save(cart);
        System.out.println(cart);

        cart.addItem(new Item("Mobile"));
        careTaker.save(cart);
        System.out.println(cart);

        cart.addItem(new Item("Book"));
        careTaker.save(cart);
        System.out.println(cart);

        cart.addItem(new Item("Marker"));
        careTaker.save(cart);
        System.out.println(cart);

        careTaker.revert(cart);
        System.out.println(cart);

        careTaker.revert(cart);
        System.out.println(cart);

        careTaker.revert(cart);
        System.out.println(cart);

        careTaker.revert(cart);
        System.out.println(cart);

        careTaker.revert(cart);
        System.out.println(cart);
    }
}
