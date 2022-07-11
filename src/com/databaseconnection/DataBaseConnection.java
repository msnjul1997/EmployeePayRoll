package com.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public Connection connection;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        final String userName = "root";
        final String password = "Avani@1234";
        final String baseURL = "jdbc:mysql://localhost:3306";
        final String database = "/employee_payroll_service";
        final String finalURL = new StringBuffer(baseURL).append(database).toString();
        try {
            connection = DriverManager.getConnection(finalURL,userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
