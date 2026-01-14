package com.myorganisation.controller;

import com.myorganisation.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/student/profile")
public class StudentProfileController extends HttpServlet {

    StudentModel studentModel = null;

    public StudentProfileController() {
        studentModel = new StudentModel();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        int id = Integer.parseInt(req.getParameter("id"));
        PrintWriter out = res.getWriter();
        out.println(studentModel.getStudentProfile(id));
    }
}
