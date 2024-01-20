package com.example.mygalleyappfinal.models;

public class UserModel {
    String fname;
    String lname;
    String email;
    String id;

    public UserModel() {
    }

    public UserModel(String fname, String lname, String email, String id) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
