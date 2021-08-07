package com.example.PWCAssignment.dao;

import com.example.PWCAssignment.models.Complaint;

import java.sql.*;
import java.util.ArrayList;

public class ComplaintService {
    private final DataBaseConnection dataBaseConnection;

    public ComplaintService() {
        dataBaseConnection = new DataBaseConnection();
    }

   public void insertDataToComplaintTable(Complaint complaint) throws SQLException, ClassNotFoundException {
       Connection con = dataBaseConnection.getConnection();
       Statement st = con.createStatement();
       String query = "insert into Complaint values(?,?,?,?,?,?,?,?)";
       PreparedStatement pst = con.prepareStatement(query);
       pst.setInt(1,complaint.getNumber());
       pst.setString(2,complaint.getStatus());
       pst.setString(3,complaint.getClientName());
       pst.setString(4,complaint.getType());
       pst.setString(5,complaint.getAdditionalNote());
       pst.setString(6,complaint.getBranch());
       pst.setString(7,complaint.getCriticalOrNot());
       pst.setString(8,complaint.getClientPhoneNumber());

       int result = pst.executeUpdate();
       st.close();
       con.close();


   }

   public ArrayList<String> compliantStatus(Complaint complaint) throws SQLException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
         Connection con = dataBaseConnection.getConnection();
         Statement st = con.createStatement();
         String que = " Select * from complaint where phoneNumber = ?  ";
         PreparedStatement pst = con.prepareStatement(que);
         pst.setString(1,complaint.getClientPhoneNumber());
         ResultSet rs = pst.executeQuery();
         while(rs.next()){
             list.add( rs.getInt(1)+ ": is " + rs.getString(2) );
         }
         con.close();
         pst.close();
         return list;


   }
   public ArrayList<Complaint> ComplaintsWithNewStatus() throws SQLException, ClassNotFoundException {
       ArrayList<Complaint> list = new ArrayList<>();
       Connection con = dataBaseConnection.getConnection();
       Statement st = con.createStatement();
       Complaint complaint ;
       String que = " Select * from complaint where status = ?  ";
       PreparedStatement pst = con.prepareStatement(que);
       pst.setString(1,"new");
       ResultSet rs = pst.executeQuery();
       while(rs.next()){
           complaint = new Complaint();
           complaint.setClientName(rs.getString(3));
           complaint.setNumber(rs.getInt(1));
           complaint.setAdditionalNote(rs.getString(5));
           complaint.setBranch(rs.getString(6));
           complaint.setType(rs.getString(4));
           complaint.setStatus(rs.getString(2));
           list.add( complaint);
       }
       con.close();
       pst.close();
       return list;
   }
   public void updateStatus(String status, int num) throws SQLException, ClassNotFoundException {
       Connection con = dataBaseConnection.getConnection();
       String que = " Update Complaint set status =?  where complaintNumber=?";
       PreparedStatement pst = con.prepareStatement(que);
       pst.setString(1, status);
       pst.setInt(2, num);
       int rowsAffected = pst.executeUpdate();
       con.close();
       pst.close();

   }
}
