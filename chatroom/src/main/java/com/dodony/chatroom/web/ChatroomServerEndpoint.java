package com.dodony.chatroom.web;


import com.dodony.chatroom.bean.Request;
import com.dodony.chatroom.bean.Response;
import com.dodony.chatroom.bean.ResponseData;
import com.dodony.chatroom.bean.Users;
import com.dodony.chatroom.service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.dodony.chatroom.utils.WebSocketUtils.*;

@RestController
@ServerEndpoint("/chatroom/{platform}/{roomid}/{randUuid}")
public class ChatroomServerEndpoint {

    // json处理工具
    private ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(ChatroomServerEndpoint.class);

    public static final Map<String, Users> MAPUSERS = new ConcurrentHashMap<>();

    private static UsersService userService;

    @Autowired
    public void setUserService(UsersService userService){
        ChatroomServerEndpoint.userService = userService;
    }

    @OnOpen
    public void openSession(@PathParam("platform") String platform, @PathParam("roomid") String roomid,
                            @PathParam("randUuid") String randUuid, Session session) throws JsonProcessingException{
        ONLINE_USER_SESSIONS.put(randUuid, session);

        Response response = new Response();
        ResponseData responseData = new ResponseData();
        response.setType("welcome");
        responseData.setOnlineCount(ONLINE_USER_SESSIONS.size());
        response.setData(responseData);

        String responseJson = mapper.writeValueAsString(response);
//        logger.info("用户登陆：" +responseJson);
        sendMessageAll(responseJson);
    }

    @OnMessage
    public void onMessage(@PathParam("platform") String platform, @PathParam("roomid") String roomid,
                          @PathParam("randUuid") String randUuid, String message) throws JsonProcessingException {
//        logger.info("接收消息：" +message);
        Response response = new Response();
        ResponseData responseData = new ResponseData();
        Request request = mapper.readValue(message, Request.class);
        String inviteCode = request.getInviteCode();
        String type = request.getType();
        // 授权-检测邀请码
        if(type.equals("auth")) {
            Users user =  userService.selectUserByName(inviteCode + "%");
            String nickName = "";
            if(user != null) {
                nickName = user.getNickName();
            }
            if(nickName.length() > 0) {
                response.setType("auth-success");
                responseData.setNickName(nickName);
                responseData.setAvatarUrl(user.getAvatarUrl());
                response.setData(responseData);
                MAPUSERS.put(inviteCode, user);
                // 单通知
                String responseJson = mapper.writeValueAsString(response);
                sendMessage(ONLINE_USER_SESSIONS.get(randUuid), responseJson);
                // 全通知
                response.setType("login-notify");
                String notifyJson = mapper.writeValueAsString(response);
                sendMessageAll(notifyJson);
            } else {
                response.setType("auth-failure");
                String responseJson = mapper.writeValueAsString(response);
                sendMessage(ONLINE_USER_SESSIONS.get(randUuid), responseJson);
            }
        } else {
            // 鉴权
            Users user = MAPUSERS.get(inviteCode);
            String nickName = "";
            String avatarUrl = "";
            if(user != null) {
                nickName = user.getNickName();
                avatarUrl = user.getAvatarUrl();
            }
            // 有名称，则可执行发送消息任务
            if (nickName.length() > 0) {
                //String res = "{\"type\":\"data\",\"data\":{\"username\":\"" +roomid+ "\",\"content\":\"" + response.getData().getContent() + "\"}}";
                //sendMessageAll(res);
                String content = request.getData().getContent();
                response.setType("data");
                responseData.setContent(content);
                responseData.setNickName(nickName);
                responseData.setAvatarUrl(avatarUrl);
                response.setData(responseData);
                // 全通知
                String responseJson = mapper.writeValueAsString(response);
                sendMessageAll(responseJson);
            }
            // heartbeat不需要鉴权
            else if (type.equals("heartbeat")) {
                double rand = Math.random();
                int num = (int) (rand * 10) + 5;
//                logger.info("心跳秒数：" + num);
                //String res = "{\"type\":\"heartbeat\",\"data\":{\"next_interval\":\"" + num + "\"}}";
                response.setType("heartbeat");
                responseData.setNext_interval(num);
                response.setData(responseData);
//                logger.info("response#：" + response);
                String responseJson = mapper.writeValueAsString(response);
                sendMessage(ONLINE_USER_SESSIONS.get(randUuid), responseJson);
            }
            else {
                response.setType("auth-failure");
                String responseJson = mapper.writeValueAsString(response);
                sendMessage(ONLINE_USER_SESSIONS.get(randUuid), responseJson);
            }
        }
    }

    @OnClose
    public void onClose(@PathParam("platform") String platform, @PathParam("roomid") String roomid,
                        @PathParam("randUuid") String randUuid, Session session) throws JsonProcessingException{
        ONLINE_USER_SESSIONS.remove(randUuid);
        //String res = "{\"type\":\"goodbye\",\"data\":{\"content\":\"用户[" + roomid + "] 已经离开聊天室了！\"}}";
        Response response = new Response();
        ResponseData responseData = new ResponseData();
//        Users user = MAPUSERS.get(inviteCode);
        Users user = new Users();
        String nickName = user.getNickName();
        response.setType("goodbye");
        if (user != null) {
            responseData.setContent("用户[" + nickName + "] 已经离开聊天室了！");
        }
        String responseJson = mapper.writeValueAsString(response);
        sendMessageAll(responseJson);

        try {
            session.close();
        } catch (IOException e) {
//            logger.error("onClose error", e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onError exception", e);
        }
//        logger.info("Throwable msg " + throwable.getMessage());
    }





}
