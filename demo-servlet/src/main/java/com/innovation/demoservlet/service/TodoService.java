package com.innovation.demoservlet.service;

import com.innovation.demoservlet.model.Todo;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-16 04:18 PM Saturday
 **/
public interface TodoService {
    List<Todo> getTodos();

    void saveTodo(Todo todo);

    Todo getTodoById(int id);

    void updateTodo(Todo todo);

    void deleteTodo(int id);
}
