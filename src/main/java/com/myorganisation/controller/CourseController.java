package com.myorganisation.controller;

import com.myorganisation.model.CourseModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/courses")
public class CourseController extends HttpServlet {

    private final CourseModel courseModel;

    public CourseController() {
        courseModel = new CourseModel();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.println(courseModel.getCourse(id));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        float duration = Float.parseFloat(req.getParameter("duration"));
        float fee = Float.parseFloat(req.getParameter("fee"));

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.println(courseModel.registerCourse(name, duration, fee));
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        float duration = Float.parseFloat(req.getParameter("duration"));
        float fee = Float.parseFloat(req.getParameter("fee"));

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.println(courseModel.updateCourse(id, name, duration, fee));
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        out.println(courseModel.removeCourse(id));
    }
}
