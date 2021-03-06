package com.example.PWCAssignment.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
    // to terminate the session
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setAttribute("ClientFullName",null);
        session.setAttribute("Email",null);
        session.setAttribute("pass",null);
        RequestDispatcher rq=req.getRequestDispatcher("index.jsp");
        rq.forward(req,resp);
    }
}
