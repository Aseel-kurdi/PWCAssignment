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
import java.util.Random;

@WebServlet("/ComplaintPage")
public class ComplaintPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ComplaintPage.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String complaintType = req.getParameter("complaint");
        String critical = req.getParameter("critical");
        String notCritical = req.getParameter("not Critical");
        String additionalNote = req.getParameter("AdditionalNote");
        String branch = req.getParameter("branch");
        int complaintNumber = generateRandomUniqueNumber() ;
        String status = "new" ;
        HttpSession session = req.getSession();
        String clientName = (String) session.getAttribute("ClientFullName");
        String clientPhoneNumber = (String)session.getAttribute("phoneNumber");
        session.setAttribute("complaintNumber",complaintNumber);
        session.setAttribute("status",status);
        String criticalOrNot;
        ArrayList<String> list = new ArrayList<>();
        if( critical == null)
            criticalOrNot = notCritical;
        else
            criticalOrNot = critical;

        Complaint complaint = new Complaint(status,clientName,complaintType,additionalNote,criticalOrNot,branch,clientPhoneNumber,complaintNumber);
        ComplaintService complaintService = new ComplaintService();
        try {
            complaintService.insertDataToComplaintTable(complaint);
            list = complaintService.compliantStatus(complaint); // each index status + number of comp
            session.setAttribute("list",list);

            if(list.size() != 0){
                String temp = "temp";
                session.setAttribute("temp",temp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ComplaintPage.jsp");
        requestDispatcher.forward(req,resp);
    }

    public int generateRandomUniqueNumber(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        int a = random.nextInt(999)+1; // this will give numbers between 1 and 999.

        if (!arrayList.contains(a)) {
            arrayList.add(a);
            return a;
        }
        else
            return random.nextInt(999)+1;

    }
}

