package com.ssafy.bruteforce.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "question")
public class Question implements Serializable{
    private static final long serialVersionUID = 1L;
    public String qid;
    public String title;
    public String contents;
    public String writerUid;
    public String writerName;
    public String[] tag;
    public Boolean bClosed;
    public Date timestamp;
    public int score;
    public List<Answer> answers;

    public Question() {
    }

    public Question(String qid, String title, String contents, String writerUid, String writerName, String[] tag) {
        this.qid = qid;
        this.title = title;
        this.contents = contents;
        this.writerUid = writerUid;
        this.writerName = writerName;
        this.tag = tag;
        this.bClosed = false;
        this.timestamp = new Date();
        this.score = 0;
        this.answers = new ArrayList<Answer>();
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

    public String[] getTag() {
        return tag;
    }

    public void setTag(String[] tag) {
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question [answers=" + answers.toString() + ", bClosed=" + bClosed + ", contents=" + contents + ", qid=" + qid
                + ", score=" + score + ", tag=" + Arrays.toString(tag) + ", timestamp=" + timestamp + ", title=" + title
                + ", writerName=" + writerName + ", writerUid=" + writerUid + "]";
    }

    
    
}