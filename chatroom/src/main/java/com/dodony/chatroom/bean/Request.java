package com.dodony.chatroom.bean;

public class Request {

    private String type;

    private String inviteCode = "";

    private RequestData data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public RequestData getData() {
        return data;
    }

    public void setData(RequestData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", data=" + data +
                '}';
    }
}
