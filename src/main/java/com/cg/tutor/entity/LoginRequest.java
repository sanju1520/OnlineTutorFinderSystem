package com.cg.tutor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="login_Request_tbl")
public class LoginRequest {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    
    @Column(name="email_Id")
    private String emailId;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password,String emailId) {
        this.username = username;
        this.password = password;
        this.emailId=emailId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}