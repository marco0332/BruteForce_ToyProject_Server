package com.ssafy.bruteforce.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "board")
public class Question implements Serializable{
    @Id
    public String qid;
    public String type;
    public String title;
    public String contents;
    public String writerUid;
    public String writerName;
    public int[] tag;
    public Boolean bClosed;
    public Date timestamp;
    public int score;
    public List<Comment> comments;
    private static final long serialVersionUID = 1L;

    public Question() {
    }

    public Question(String title, String contents, String writerUid, String writerName, int[] tag) {
        this.qid = new ObjectId().toString();
        this.title = title;
        this.contents = contents;
        this.writerUid = writerUid;
        this.writerName = writerName;
        this.type = "question";
        this.tag = tag;
        this.bClosed = false;
        this.timestamp = new Date();
        this.score = 0;
        this.comments = new ArrayList<Comment>();
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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

    public int[] getTag() {
        return tag;
    }

    public void setTag(int[] tag) {
        this.tag = tag;
    }

    public Boolean isbClosed() {
        return bClosed;
    }

    public void setbClosed(Boolean bClosed) {
        this.bClosed = bClosed;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    @Override
    public String toString() {
        return "Question [comments=" + comments.toString() + ", type=" + type + ", bClosed=" + bClosed + ", contents=" + contents + ", qid=" + qid
                + ", score=" + score + ", tag=" + Arrays.toString(tag) + ", timestamp=" + timestamp + ", title=" + title
                + ", writerName=" + writerName + ", writerUid=" + writerUid + "]\n";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    
    
}