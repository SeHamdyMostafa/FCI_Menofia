package com.example.FCI_Menofia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnector {
    public static Connection getconnection() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/studentsdatabase", "root", "");
        return connection;
    }
}
