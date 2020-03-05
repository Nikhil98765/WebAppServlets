package com.java.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertyReaderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties p = (Properties) getServletContext().getAttribute("properties");
        PrintWriter out = resp.getWriter();
        // get the property value and print it out
        getServletContext().log(p.getProperty("name"));
        getServletContext().log(p.getProperty("rollno"));
        getServletContext().log(p.getProperty("university"));
        out.println("Name - " + p.getProperty("name"));
        out.println("RollNo - " + p.getProperty("rollno"));
        out.println("Uni - " + p.getProperty("university"));

    }
}
