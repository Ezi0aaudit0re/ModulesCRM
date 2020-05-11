package com.web_app.testDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDBServlet")
public class TestDBServlet extends HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // setup connection variable
        String user = "root";
        String pass = "root";

        String jdurl = "jdbc:mysql://localhost:3306/ModulesCRM?useSSL=false&serverTimezone=UTC";

        String driver = "com.mysql.jdbc.Driver";

        // get connection to database

        try {

            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdurl);

            Connection connection = DriverManager.getConnection(jdurl, user, pass);

            out.println("Success !!");

            connection.close();

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }


    }
}
