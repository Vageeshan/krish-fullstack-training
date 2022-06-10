package com.system.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-10 12:07 PM Friday
 **/
public class Library {

    private static Map<String, Book> bookMap = new HashMap<>();

    static {
        loadBookAuthors();
    }

    public static Book getAuthor(String authorName) {
        System.out.println(authorName);
        return (Book) bookMap.get(authorName).clone();
    }

    public static void loadBookAuthors() {
        bookMap.put("Krishantha", new JavaBook());
        bookMap.put("kathy sierra", new SpringBootBook());
    }
}
