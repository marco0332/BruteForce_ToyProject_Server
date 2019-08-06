package com.ssafy.bruteforce.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
public class Comment implements Serializable{
    @Id
    public String cid;
    public String writerUid;
    public String writerName;
    public String contents;
    public Date timestamp;
    private static final long serialVersionUID = 1L;
    
    public Comment(){}
    
    public Comment(String writerUid, String writerName, String contents) {
        this.writerUid = writerUid;
        this.writerName = writerName;
        this.contents = contents;
        this.timestamp = new Date();
    }

    public String getCid() {
        return cid;
    }
    
    public void setCid(String cid) {
        this.cid = cid;
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

    @Override
    public String toString() {
        return "Comment [cid=" + cid + ", contents=" + contents + ", timestamp=" + timestamp + ", writerName="
                + writerName + ", writerUid=" + writerUid + "]";
    }
    
}