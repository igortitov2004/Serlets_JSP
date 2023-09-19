package com.example.crudapp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector{
    public static final DBConnector INSTANCE = new DBConnector();
    private DBConnector(){}

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_for_servlets", "root", "matveibrat19");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
