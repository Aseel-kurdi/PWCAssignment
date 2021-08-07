package com.example.PWCAssignment.controller;

import com.example.PWCAssignment.dao.ClientService;
import com.example.PWCAssignment.models.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignUpPage")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq=req.getRequestDispatcher("SignUp.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String clientFirstName = req.getParameter("FirstName");
       String clientLastName = req.getParameter("LastName");
       String email = req.getParameter("Email");
       String phoneNumber = req.getParameter("phoneNumber");
       String pass = req.getParameter("pass");
       Client client = new Client(phoneNumber,clientFirstName,clientLastName,email,pass);
       ClientService clientService = new ClientService();
        try {
            if(!clientService.isClientAlreadyExist(phoneNumber)){
                clientService.signUp(client);
            }
            else {
                String invalidClientData = "The client is already in the system";
                req.setAttribute("invalidClientData",invalidClientData);
                RequestDispatcher rq=req.getRequestDispatcher("SignUp.jsp");
                rq.forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rq=req.getRequestDispatcher("SignUp.jsp");
        rq.forward(req,resp);
    }
}
