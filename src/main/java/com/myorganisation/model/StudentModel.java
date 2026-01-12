package com.myorganisation.model;

import java.sql.*;

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

    public String getAllStudents() {
        String response = "";
        String message = "Student not found";
        boolean isDataFound = false;
        String sqlQuery = "SELECT * FROM students";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            StringBuilder listOfJson = new StringBuilder("[");

            while (resultSet.next()) {
                isDataFound = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                long phone = resultSet.getLong("phone");
                String email = resultSet.getString("email");
                int courseId = resultSet.getInt("course_id");

                String course = "{" +
                        "\"id\": \"" + id + "\"," +
                        "\"name\": \"" + name + "\"," +
                        "\"phone\": \"" + phone + "\"," +
                        "\"email\": \"" + email + "\"," +
                        "\"courseId\": \"" + courseId + "\"" +
                        "}";

                listOfJson.append(course).append(",");
            }
            listOfJson.deleteCharAt(listOfJson.length() - 1);
            listOfJson.append("]");

            response = listOfJson.toString();
        } catch(SQLException e) {
            isDataFound = false;
            System.out.println("An exception occurred during fetching students details: " + e.getMessage());
            message = "An error occurred. Please try again later";
        }

        if(isDataFound) {
            return response;
        } else {
            return  "{" +
                    "\"message\": \"" + message + "\"" +
                    "}";
        }
    }

    public String getStudent(int studentId) {
        String response = "";
        String message = "Student not found";
        boolean isDataFound = false;
        String sqlQuery = "SELECT * FROM students WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder listOfJson = new StringBuilder("[");

            while (resultSet.next()) {
                isDataFound = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                long phone = resultSet.getLong("phone");
                String email = resultSet.getString("email");
                int courseId = resultSet.getInt("course_id");

                String course = "{" +
                        "\"id\": \"" + id + "\"," +
                        "\"name\": \"" + name + "\"," +
                        "\"phone\": \"" + phone + "\"," +
                        "\"email\": \"" + email + "\"," +
                        "\"courseId\": \"" + courseId + "\"" +
                        "}";

                listOfJson.append(course).append(",");
            }
            listOfJson.deleteCharAt(listOfJson.length() - 1);
            listOfJson.append("]");

            response = listOfJson.toString();
        } catch(SQLException e) {
            isDataFound = false;
            System.out.println("An exception occurred during fetching students details: " + e.getMessage());
            message = "An error occurred. Please try again later";
        }

        if(isDataFound) {
            return response;
        } else {
            return  "{" +
                    "\"message\": \"" + message + "\"" +
                    "}";
        }
    }

    public String updateStudent(int id, String name, Long phone, String email, Integer courseId) {
        String sqlQuery = "UPDATE students SET name = ?, phone = ?, email = ?, course_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, courseId);
            preparedStatement.setInt(5, id);

            preparedStatement.execute();

            return "Student updated successfully";
        } catch(SQLException e) {
            System.out.println("An exception occurred during updation: " + e.getMessage());
            return "Student updation failed";
        }
    }

    public String removeStudent(int id) {
        String sqlQuery = "DELETE FROM students WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            return "Student removed successfully";
        } catch(SQLException e) {
            System.out.println("An exception occurred during deletion: " + e.getMessage());
            return "Student deletion failed";
        }
    }

 }
