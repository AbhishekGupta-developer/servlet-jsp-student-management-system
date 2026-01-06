package com.myorganisation.controller;


import com.myorganisation.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/student")
public class StudentController extends HttpServlet {
    StudentModel studentModel = null;

    public StudentController() {
        studentModel = new StudentModel();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h4>GET API</h4>");
    }

//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        res.setContentType("application/json");
//
//        String name = req.getParameter("name");
//        Long phone = Long.valueOf(req.getParameter("phone"));
//        String email = req.getParameter("email");
//
//        String response = studentModel.registerStudent(name, phone, email);
//        String jsonResponse = "{\"status\": \"" + response + "\"}";
//
//        PrintWriter out = res.getWriter();
//        out.println(jsonResponse);
//    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h4>PUT API</h4>");
    }

    @Override
    public void doPatch(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h4>PATCH API</h4>");
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h4>DELETE API</h4>");
    }

}
