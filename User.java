package com.test.StudentManageSystem;

public class User {
    private String username;
    private String password;
    private String idnumber;
    private String phnumber;
    public User() {}
    public User(String username, String password, String identitynumber, String phonenumber) {
        this.username = username;
        this.password = password;
        this.idnumber = identitynumber;
        this.phnumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentitynumber() {
        return idnumber;
    }

    public void setIdentitynumber(String identitynumber) {
        this.idnumber = identitynumber;
    }

    public String getPhonenumber() {
        return phnumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phnumber = phonenumber;
    }
}
