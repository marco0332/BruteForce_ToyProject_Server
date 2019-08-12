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
    private String profile;
    private int point;
    private String group;
    private Boolean bAdmin;
    private Boolean bDeactivated;
    private static final long serialVersionUID = 1L;

    public User() {
    }

    public User(String userid, String pw, String name, String photoURL, int point) {
        this.userid = userid;
        this.pw = pw;
        this.name = name;
        this.photoURL = "";
        this.point = 0;
        this.group = "";
        this.profile = "";
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

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User [bAdmin=" + bAdmin + ", bDeactivated=" + bDeactivated + ", group=" + group + ", name=" + name
                + ", photoURL=" + photoURL + ", point=" + point + ", profile=" + profile + ", pw=" + pw + ", userid="
                + userid + "]";
    }

    
}