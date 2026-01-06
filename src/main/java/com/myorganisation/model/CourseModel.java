package com.myorganisation.model;

import java.sql.*;

public class CourseModel {
    DbConnection dbConnection = null;
    Connection connection = null;

    public CourseModel() {
        System.out.println("Inside CourseModel constructor");
        dbConnection = DbConnection.getDbConnection();
        connection = dbConnection.getConnection();
        createdTableCoursesIfNotExist();
    }

    private void createdTableCoursesIfNotExist() {
        String sqlQuery =
                "CREATE TABLE IF NOT EXISTS courses " +
                        "(" +
                        "id INT PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR(255) NOT NULL, " +
                        "duration FLOAT, " +
                        "fee FLOAT" +
                        ")";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
            System.out.println("Courses table created or connected successfully!");
        } catch(SQLException e) {
            System.out.println("Table creation or connection failed: " + e.getMessage());
        }
    }

    public String registerCourse(String name, Float duration, Float fee) {
        String message = "";
        String sqlQuery = "INSERT INTO courses (name, duration, fee) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, duration);
            preparedStatement.setFloat(3, fee);

            preparedStatement.execute();

            message =  "Course registered successfully";
        } catch(SQLException e) {
            System.out.println("An exception occurred during insertion: " + e.getMessage());
            message = "Course registration failed";
        }

        return "{\"message\": \"" + message + "\"}";
    }

    public String getCourse(Integer id) {
        String response = "";
        String message = "Course not found";
        boolean isDataFound = false;
        String sqlQuery = "SELECT * FROM courses WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                isDataFound = true;
                String name = resultSet.getString("name");
                float duration = resultSet.getFloat("duration");
                float fee = resultSet.getFloat("fee");

                response = "{" +
                        "\"id\": \"" + id + "\"," +
                        "\"name\": \"" + name + "\"," +
                        "\"duration\": \"" + duration + "\"," +
                        "\"fee\": \"" + fee + "\"" +
                        "}";
            }
        } catch(SQLException e) {
            isDataFound = false;
            System.out.println("An exception occurred during fetching course details: " + e.getMessage());
            message = "An error occurred. PLease try again later";
        }

        if(isDataFound) {
            return response;
        } else {
            return  "{" +
                    "\"message\": \"" + message + "\"" +
                    "}";
        }
    }

    public String getAllCourses() {
        String response = "";
        String message = "Course not found";
        boolean isDataFound = false;
        String sqlQuery = "SELECT * FROM courses";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder listOfJson = new StringBuilder("[");

            while (resultSet.next()) {
                isDataFound = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float duration = resultSet.getFloat("duration");
                float fee = resultSet.getFloat("fee");

                String course = "{" +
                        "\"id\": \"" + id + "\"," +
                        "\"name\": \"" + name + "\"," +
                        "\"duration\": \"" + duration + "\"," +
                        "\"fee\": \"" + fee + "\"" +
                        "}";

                listOfJson.append(course).append(",");
            }
            listOfJson.deleteCharAt(listOfJson.length() - 1);
            listOfJson.append("]");

            response = listOfJson.toString();
        } catch(SQLException e) {
            isDataFound = false;
            System.out.println("An exception occurred during fetching course details: " + e.getMessage());
            message = "An error occurred. PLease try again later";
        }

        if(isDataFound) {
            return response;
        } else {
            return  "{" +
                    "\"message\": \"" + message + "\"" +
                    "}";
        }
    }

    public String updateCourse(int id, String name, float duration, float fee) {
        String message = "";
        String sqlQuery = "UPDATE courses SET name = ?,duration = ?, fee = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setFloat(2, duration);
            preparedStatement.setFloat(3, fee);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            message = "Course updated successfully";
        } catch(SQLException e) {
            System.out.println("An exception occurred: " + e.getMessage());
            message = "Course updation failed. Try again later.";
        }

        return "{\"message\": \"" + message + "\"}";
    }

    public String removeCourse(int id) {
        String message = "";
        String sqlQuery = "DELETE FROM courses WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            message = "Course removed successfully";
        } catch(SQLException e) {
            System.out.println("An exception occurred: " + e.getMessage());
            message = "Course removal failed. Try again later";
        }

        return "{\"message\": \"" + message + "\"}";
    }
 }
