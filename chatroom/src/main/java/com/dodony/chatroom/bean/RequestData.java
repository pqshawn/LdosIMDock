package com.dodony.chatroom.bean;

public class RequestData {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "content='" + content + '\'' +
                '}';
    }
}
