package com.myorganisation.controller;

import com.myorganisation.model.CourseModel;
import com.myorganisation.model.DbConnection;
import com.myorganisation.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api")
public class ServerController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        DbConnection dbConnection = DbConnection.getDbConnection();
        StudentModel studentModel = new StudentModel();
        CourseModel courseModel = new CourseModel();

        res.setContentType("application/json");

        String jsonResponse = "{\"status\": \"API Server is live!\"}";

        PrintWriter out = res.getWriter();
        out.println(jsonResponse);
    }
}
