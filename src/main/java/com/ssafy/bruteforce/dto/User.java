package com.ssafy.bruteforce.dto;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User{
    
    public String userid;
    public String pw;
    public String name;

    public User(){}

    public User(String userid, String pw, String name){
        this.userid = userid;
        this.pw = pw;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "userid = %s, pw = %s, name = %name", userid, pw,name
        );
    }
}