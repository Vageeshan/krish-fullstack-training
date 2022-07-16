package com.innovation.demoservlet.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-07-16 04:19 PM Saturday
 **/
public class DataSource {
    private static volatile DataSource dataSource;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private DataSource() {
        if (dataSource != null) {
            throw new RuntimeException("We are violating singleton rule");
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(CLASS_NAME);
            connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection with the db established");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static DataSource getDataSource() {
        // checking the object availability
        if (dataSource == null) {
            // thread safe
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }
}
