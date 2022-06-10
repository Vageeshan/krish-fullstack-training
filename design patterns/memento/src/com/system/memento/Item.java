package com.system.memento;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 03:43 PM Friday
 **/
public class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
