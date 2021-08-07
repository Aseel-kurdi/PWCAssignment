package com.example.PWCAssignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// this class is responsible to the connection with the database
public class DataBaseConnection {
    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "P@ssw0rd");
        return connection;
    }
}