package com.example.PWCAssignment.models;

public class Complaint {
    private String status ;
    private String clientName ;
    private String type ;
    private String additionalNote ;
    private String criticalOrNot ;
    private String branch ;
    private String clientPhoneNumber ;
    private int number ;

    public Complaint(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }
    public Complaint() {
        ;
    }

    public Complaint(String status, String clientName, String type, String additionalNote, String criticalOrNot, String branch, int number) {
        this.status = status;
        this.clientName = clientName;
        this.type = type;
        this.additionalNote = additionalNote;
        this.criticalOrNot = criticalOrNot;
        this.branch = branch;
        this.number = number;
    }

    public Complaint(String status, String clientName, String type, String additionalNote, String criticalOrNot, String branch, String clientPhoneNumber, int number) {
        this.status = status;
        this.clientName = clientName;
        this.type = type;
        this.additionalNote = additionalNote;
        this.criticalOrNot = criticalOrNot;
        this.branch = branch;
        this.clientPhoneNumber = clientPhoneNumber;
        this.number = number;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getCriticalOrNot() {
        return criticalOrNot;
    }

    public void setCriticalOrNot(String criticalOrNot) {
        this.criticalOrNot = criticalOrNot;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdditionalNote() {
        return additionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        this.additionalNote = additionalNote;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
