package com.myorganisation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentModel {
    DbConnection dbConnection = null;
    Connection connection = null;

    public StudentModel() {
        System.out.println("Inside StudentModel constructor");
        dbConnection = DbConnection.getDbConnection();
        connection = dbConnection.getConnection();
        createdTableStudentsIfNotExist();
    }

    private void createdTableStudentsIfNotExist() {
        String sqlQuery =
                "CREATE TABLE IF NOT EXISTS students " +
                        "(" +
                        "id INT PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR(255) NOT NULL, " +
                        "phone BIGINT NOT NULL, " +
                        "email VARCHAR(255), " +
                        "course_id INT" +
                        ")";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
            System.out.println("Student table created or connected successfully!");
        } catch(SQLException e) {
            System.out.println("Table creation or connection failed: " + e.getMessage());
        }
    }

    public String registerStudent(String name, Long phone, String email, Integer courseId) {
        String sqlQuery = "INSERT INTO students (name, phone, email, course_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, courseId);

            preparedStatement.execute();

            return "Student registered successfully";
        } catch(SQLException e) {
            System.out.println("An exception occurred during insertion: " + e.getMessage());
            return "Student registration failed";
        }
    }
 }
