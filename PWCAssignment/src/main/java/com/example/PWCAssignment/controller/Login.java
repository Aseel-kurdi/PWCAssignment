package com.example.PWCAssignment.controller;

import com.example.PWCAssignment.dao.ClientService;
import com.example.PWCAssignment.dao.ComplaintService;
import com.example.PWCAssignment.models.Client;
import com.example.PWCAssignment.models.Complaint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/LoginPage")
public class Login  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq=req.getRequestDispatcher("Login.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("ClientFullName");
        String phoneNumber = req.getParameter("phoneNumber");
        HttpSession session = req.getSession();
        session.setAttribute("ClientFullName",clientName);
        session.setAttribute("phoneNumber",phoneNumber);
        ArrayList<String> list = new ArrayList<>();
        ComplaintService complaintService = new ComplaintService();
        Complaint complaint = new Complaint(phoneNumber);
        try {
            list = complaintService.compliantStatus(complaint);
            session.setAttribute("list",list);
            if(list.size() != 0){
                String temp = "temp";
                session.setAttribute("temp",temp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String temp2[] ;
        String temp1[] ;
        String clientFirstName;
        String clientLastName;
        ArrayList<String[]> temporary = new ArrayList<>();
        temporary.add(clientName.split(" "));
        if(temporary.get(0).length == 2){
            temp2=temporary.get(0);
            clientFirstName = temp2[0] ;
            clientLastName =  temp2[1];

        }
        else{
            temp1 = temporary.get(0);
            clientFirstName = temp1[0];
            clientLastName =" ";
        }
        String email = req.getParameter("Email");
        String pass = req.getParameter("pass");
        Client client = new Client(clientFirstName,clientLastName,email,pass);
        ClientService clientService = new ClientService();
        try {
            if(clientFirstName.equalsIgnoreCase("admin") && clientLastName == " " &&
                 email.equalsIgnoreCase( "PWC@gmail.com") && pass.equals("00") &&
                      phoneNumber.equals("00")){
                try {
                    ArrayList<Complaint> complaintArrayList =new ArrayList<>();
                    complaintArrayList = complaintService.ComplaintsWithNewStatus();
                    session.setAttribute("complaintArrayList",complaintArrayList);
                }  catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                    RequestDispatcher rq=req.getRequestDispatcher("AdminPage.jsp");
                    rq.forward(req,resp);

            } else if(clientService.login(client)){
                RequestDispatcher rq=req.getRequestDispatcher("ComplaintPage.jsp");
                rq.forward(req,resp);

            }else{
                String invalidClientData = "Client name, email or password is incorrect, please try again ^^";
                req.setAttribute("invalidClientData",invalidClientData);

                RequestDispatcher rq=req.getRequestDispatcher("Login.jsp");
                rq.forward(req,resp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
