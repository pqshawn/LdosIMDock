package com.dodony.chatroom.bean;

public class Users {

    private int users_id;
    private String nickName;
    private String avatarUrl;
    private String expire_time;
    private String sessionid;

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
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

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }


    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }


    @Override
    public String toString() {
        return "Users{" +
                "users_id=" + users_id +
                ", sessionid='" + sessionid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", expire_time='" + expire_time + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
