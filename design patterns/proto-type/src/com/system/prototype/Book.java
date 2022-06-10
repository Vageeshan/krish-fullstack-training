package com.system.prototype;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 12:00 PM Friday
 **/
public abstract class Book implements Cloneable {
    protected String author;

    abstract void addBook();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
