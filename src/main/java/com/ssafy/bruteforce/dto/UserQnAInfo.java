package com.ssafy.bruteforce.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserQnAInfo implements Serializable {
    @Id
    private String qid;
    private String title;
    private static final long serialVersionUID = 1L;
    
    public UserQnAInfo() {
    }

    public UserQnAInfo(String qid, String title) {
        this.qid = qid;
        this.title = title;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "UserQnAInfo [qid=" + qid + ", title=" + title + "]";
    }

    
}