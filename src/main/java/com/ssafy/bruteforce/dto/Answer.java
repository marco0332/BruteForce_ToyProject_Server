package com.ssafy.bruteforce.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "answer")
public class Answer implements Serializable{
    @Id
    public String aid;
    public String writerUid;
    public String writerName;
    public String contents;
    public Boolean bSelection;
    public Date timestamp;
    public int score;
    public List<Comment> comments;
    private static final long serialVersionUID = 1L;

    public Answer(){}

    public Answer(String writerUid, String writerName, String contents) {
        this.aid = new ObjectId().toString();
        this.writerUid = writerUid;
        this.writerName = writerName;
        this.contents = contents;
        this.timestamp = new Date();
        this.score = 0;
        this.bSelection = false;
        this.comments = new ArrayList<Comment>();
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getWriterUid() {
        return writerUid;
    }

    public void setWriterUid(String writerUid) {
        this.writerUid = writerUid;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean isbSelection() {
        return bSelection;
    }

    public void setbSelection(Boolean bSelection) {
        this.bSelection = bSelection;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Answer [score=" + score + ", aid=" + aid + ", bSelection=" + bSelection + ", comments=" + comments.toString() + ", contents=" + contents
                + ", timestamp=" + timestamp + ", writerName=" + writerName + ", writerUid=" + writerUid + "]";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
}