package com.innovation.demoservlet.web;

import com.google.gson.Gson;
import com.innovation.demoservlet.Dto.APIResponse;
import com.innovation.demoservlet.model.Todo;
import com.innovation.demoservlet.service.TodoService;
import com.innovation.demoservlet.service.TodoServiceImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class TodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoService todoService;

    public void init() {
        todoService = new TodoServiceImplementation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTodo(request, response);
                    break;
                case "/delete":
                    deleteTodo(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTodo(request, response);
                    break;
                default:
                    listTodo(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listTodo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Todo> todos = todoService.getTodos();
        request.setAttribute("todolist", todos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Todo todo = todoService.getTodoById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo-form.jsp");
        request.setAttribute("todo", todo);
        dispatcher.forward(request, response);
    }

    private void insertTodo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String task = request.getParameter("task");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        Todo todo = new Todo(task, author, description);
        todoService.saveTodo(todo);
        response.sendRedirect("list");
    }

    private void updateTodo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String task = request.getParameter("task");
        String author = request.getParameter("author");
        String description = request.getParameter("description");

        Todo todo = new Todo(id, task, author, description);
        todoService.updateTodo(todo);
        response.sendRedirect("list");
    }

    private void deleteTodo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Todo todo = todoService.getTodoById(id);
        todoService.deleteTodo(id);
        APIResponse apiResponse = new APIResponse(todo, "Success", 200);
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(apiResponse));
    }
}
