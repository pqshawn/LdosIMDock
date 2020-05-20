package com.dodony.chatroom.bean;

public class ResponseData {
    private String content;
    private String nickName;
    private String avatarUrl;
    private int next_interval;
    private int onlineCount;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getNext_interval() {
        return next_interval;
    }

    public void setNext_interval(int next_interval) {
        this.next_interval = next_interval;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "onlineCount=" + onlineCount +
                ", nickName='" + nickName + '\'' +
                ", next_interval=" + next_interval +
                ", content='" + content + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
