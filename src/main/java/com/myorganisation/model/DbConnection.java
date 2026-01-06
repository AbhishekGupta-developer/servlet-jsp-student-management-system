package com.myorganisation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private DbConnection() {
        dbUrl = "jdbc:mysql://localhost:3306/sms?createDatabaseIfNotExist=true";
        dbUser = "root";
        dbPassword = "root";

        connectDb();
    }

    private static DbConnection dbConnection = null;

    private Connection connection = null;

    public static DbConnection getDbConnection() {
        if(dbConnection == null) {
            dbConnection = new DbConnection();
        }

        return dbConnection;
    }

    private void connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Database connected successfully!");
        } catch(ClassNotFoundException e) {
            System.out.println("Mysql driver class not found: " + e.getMessage());
        } catch(SQLException e) {
            System.out.println("DB connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
