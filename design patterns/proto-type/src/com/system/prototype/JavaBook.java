package com.system.prototype;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 12:01 PM Friday
 **/
public class JavaBook extends Book {

    public JavaBook() {
        this.author = "Krish";
    }

    @Override
    void addBook() {
        System.out.println("Java Book is ready");
    }
}
