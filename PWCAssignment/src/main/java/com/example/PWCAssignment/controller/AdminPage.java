package com.example.PWCAssignment.controller;

import com.example.PWCAssignment.dao.ComplaintService;
import com.example.PWCAssignment.models.Complaint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminPage.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  take all info about the new status and view in the admin page change the status of the complaint
        String status = req.getParameter("status");
        int complaintNumber = Integer.parseInt(req.getParameter("id"));
        ComplaintService complaintService = new ComplaintService();
        HttpSession session = req.getSession();
        try {
            complaintService.updateStatus(status,complaintNumber);
            ArrayList<Complaint> complaintArrayList =new ArrayList<>();
            complaintArrayList =   complaintService.ComplaintsWithNewStatus();
            session.setAttribute("complaintArrayList",complaintArrayList);
        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminPage.jsp");
        requestDispatcher.forward(req,resp);
    }
}
