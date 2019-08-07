package com.ssafy.bruteforce.dto;

import java.io.Serializable;

public class ResultJson implements Serializable {

    // success, fail, unconnect (성공, 유효하나 데이터 없음, 서버 문제)
    private static final long serialVersionUID = 1L;
    private String state = "success"; 
    private String message = "Request Success";
    private Object contents;

    public ResultJson(){
        super();
    }

    public String getState() {
        return state;
    }

    private void setState(String state) {
        this.state = state;
    }

    public void setStaeFail(){
        setState("fail");
    }

    public void setStateUnconnect(){
        setState("unconnect");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }

    
}