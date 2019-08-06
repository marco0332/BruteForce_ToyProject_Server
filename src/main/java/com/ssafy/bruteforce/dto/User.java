package com.ssafy.bruteforce.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable {

    @Id
    private String userid;
    private String pw;
    private String name;
    private String photoURL;
    private int point;
    private Boolean bAdmin;
    private Boolean bDeactivated;
    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String userid, String pw, String name, String photoURL, int point) {
        this.userid = userid;
        this.pw = pw;
        this.name = name;
        this.photoURL = photoURL;
        this.point = point;
        this.bAdmin = false;
        this.bDeactivated = false;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Boolean getbAdmin() {
        return bAdmin;
    }

    public void setbAdmin(Boolean bAdmin) {
        this.bAdmin = bAdmin;
    }

    public Boolean getbDeactivated() {
        return bDeactivated;
    }

    public void setbDeactivated(Boolean bDeactivated) {
        this.bDeactivated = bDeactivated;
    }

    @Override
    public String toString() {
        return String.format("userid = %s, pw = %s, name = %name", userid, pw, name);
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

}