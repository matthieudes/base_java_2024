package com.harrypotter.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

    private static final String USER = "root";
    private static final String PWD = "";
    private static final String DB_URL = "jdbc:mysql://localhost:3308/harrypotter";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL,USER,PWD);
    }
}
