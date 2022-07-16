package com.innovation.demoservlet.repository;

import com.innovation.demoservlet.model.Todo;
import com.innovation.demoservlet.server.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-16 04:17 PM Saturday
 **/
public class TodoRepository {

    public static void save(Todo todo) {
        Connection connection = null;
        try {
            String query = "INSERT INTO `test`.`todo` (`task`,`author`,`description`) VALUES (?,?,?)";
            connection = DataSource.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, todo.getTask());
            preparedStatement.setString(2, todo.getAuthor());
            preparedStatement.setString(3, todo.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Todo getById(int id) {
        Todo todo = null;
        Connection connection = null;
        try {
            String query = "SELECT * FROM `todo` WHERE `id` = ?";
            connection = DataSource.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String task = rs.getString("task");
                String author = rs.getString("author");
                String description = rs.getString("description");
                todo = new Todo(id, task, author, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return todo;
    }

    public static List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DataSource.getDataSource().getConnection();
            String query = "SELECT * FROM `todo`";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String task = rs.getString("task");
                String author = rs.getString("author");
                String description = rs.getString("description");
                todos.add(new Todo(id, task, author, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return todos;
    }

    public static boolean delete(int id) {
        Connection connection = null;
        boolean rowDeleted = false;
        try {
            connection = DataSource.getDataSource().getConnection();
            String query = "DELETE FROM `test`.`todo` WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowDeleted;
    }

    public static boolean update(Todo todo) {
        boolean rowUpdated = false;
        Connection connection = null;
        try {
            String query = "UPDATE `test`.`todo` SET `task`=?,`author`=?,`description`=? WHERE id=?";
            connection = DataSource.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, todo.getTask());
            preparedStatement.setString(2, todo.getAuthor());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setInt(4, todo.getId());
            System.out.println(preparedStatement);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowUpdated;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
