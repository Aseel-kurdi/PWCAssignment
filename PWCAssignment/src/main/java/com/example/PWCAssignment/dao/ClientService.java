package com.example.PWCAssignment.dao;

import com.example.PWCAssignment.models.Client;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientService {
    private final DataBaseConnection dataBaseConnection;

    public ClientService() {
        dataBaseConnection = new DataBaseConnection();
    }

   // signUp method to take the information from the new user and store it in the database
    public int signUp(Client client) throws Exception {
        //set data in table******************************************
        int result = 0;
        Connection con = dataBaseConnection.getConnection();
        Statement st = con.createStatement();
        String query = "insert into Client values(?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,client.getPhoneNumber());
        pst.setString(2,client.getClientFirstName());
        pst.setString(3,client.getClientLastName());
        pst.setString(4,client.getEmail());
        pst.setString(5,hashPassword(client));
        result = pst.executeUpdate();
        st.close();
        con.close();
        return result;
    }

    // to encrypt the password for the client before store it in the database
    private String hashPassword(Client client) throws NoSuchAlgorithmException {
        byte[] password = String.valueOf(client.getEmail())
                .concat(client.getPass())
                .getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return new String(md.digest(password));
    }

    // take the login info from the user and makes sure if the information is correct or not
    public boolean login(Client client) throws Exception {
        Connection con = dataBaseConnection.getConnection();
        Statement st = con.createStatement();
        String que = " Select * from Client where clientFirstName  = ? and clientLastName  = ? " +
                "and email  = ? and pass  = ? ";

        PreparedStatement pst = con.prepareStatement(que);
        pst.setString(1, client.getClientFirstName());
        pst.setString(2, client.getClientLastName());
        pst.setString(3, client.getEmail());
        pst.setString(4, hashPassword(client));
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            if (rs.getString(5).equals(hashPassword(client))) {
                return true;
            }
        }
        st.close();
        con.close();
        return false;

    }

    /* this function to make sure if the client info is already in the system based on the primary key for
    the client */
    public boolean isClientAlreadyExist(String phoneNumber ) throws Exception{
        Connection con = dataBaseConnection.getConnection();
        Statement st = con.createStatement();
        String que = " Select * from Client where phoneNumber  = ?  ";
        PreparedStatement pst = con.prepareStatement(que);
        pst.setString(1,phoneNumber);
        ResultSet rs = pst.executeQuery();
        if( rs.next()) {
            return true;
        }else
            con.close();
        pst.close();
        return false;



    }


}
