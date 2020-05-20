package com.dodony.chatroom.bean;

public class Response {

    private String type;

    private ResponseData data;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
