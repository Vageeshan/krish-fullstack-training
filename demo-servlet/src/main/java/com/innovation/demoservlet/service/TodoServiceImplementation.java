package com.innovation.demoservlet.service;

import com.innovation.demoservlet.model.Todo;
import com.innovation.demoservlet.repository.TodoRepository;

import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-16 04:18 PM Saturday
 **/
public class TodoServiceImplementation implements TodoService {
    @Override
    public List<Todo> getTodos() {
        return TodoRepository.findAll();
    }

    @Override
    public void saveTodo(Todo todo) {
        TodoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(int id) {
        return TodoRepository.getById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        TodoRepository.update(todo);
    }

    @Override
    public void deleteTodo(int id) {
        TodoRepository.delete(id);
    }
}
