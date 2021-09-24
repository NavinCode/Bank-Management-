package com.BankSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC
{
    private final static String URL = "jdbc:mysql://localhost:3306/bank";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "navinsql";
    private Connection connection = null;

    public Connection connect()
    {
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
