package com.system.prototype;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 12:05 PM Friday
 **/
public class SpringBootBook extends Book {

    public SpringBootBook() {
        this.author = "Krish";
    }

    @Override
    void addBook() {
        System.out.println("Spring Boot Book is ready");
    }
}
