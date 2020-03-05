package com.java.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.java.web.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentServlet extends HttpServlet {

    HashMap<String, Student> studentInfo = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String studentName = req.getParameter("name");
        String un = req.getParameter("University");
        String rollNumber = req.getParameter("rollNo");

        Student studentDetails = new Student(studentName, un, rollNumber);

        req.setAttribute("student", studentDetails);

        studentInfo.put(rollNumber, studentDetails);


        resp.getWriter().write("registered");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String roll=req.getParameter("rollNo");

        req.setAttribute("info",studentInfo.get(roll));


    }
}
