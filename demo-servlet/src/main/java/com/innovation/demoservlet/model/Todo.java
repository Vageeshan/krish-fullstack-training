package com.innovation.demoservlet.model;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-16 04:08 PM Saturday
 **/

public class Todo {

    private int id;
    private String task;
    private String author;
    private String description;

    public Todo() {
    }

    public Todo(int id, String task, String author, String description) {
        this.id = id;
        this.task = task;
        this.author = author;
        this.description = description;
    }

    public Todo(String task, String author, String description) {
        this.task = task;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
