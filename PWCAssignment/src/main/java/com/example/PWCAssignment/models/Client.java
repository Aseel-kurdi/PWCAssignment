package com.example.PWCAssignment.models;

public class Client {
    private String phoneNumber;
    private String clientFirstName;
    private String clientLastName;
    private String email;
    private String pass;

    public Client(String clientFirstName, String clientLastName, String email, String pass) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.email = email;
        this.pass = pass;
    }

    public Client(String phoneNumber, String clientFirstName, String clientLastName, String email, String pass) {
        this.phoneNumber = phoneNumber;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.email = email;
        this.pass = pass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
