package com.myorganisation.controller;

import com.myorganisation.model.CourseModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/courses/all")
public class CoursesController extends HttpServlet {

    private final CourseModel courseModel;

    public CoursesController() {
        courseModel = new CourseModel();
    }

    @Override
    public void doGet(HttpServletRequest re, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.println(courseModel.getAllCourses());
    }
}
