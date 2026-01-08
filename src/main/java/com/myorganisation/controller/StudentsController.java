package com.myorganisation.controller;

import com.myorganisation.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/students")
public class StudentsController extends HttpServlet {
    StudentModel studentModel = null;

    public StudentsController() {
        studentModel = new StudentModel();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.println(studentModel.getAllStudents());
    }

}
