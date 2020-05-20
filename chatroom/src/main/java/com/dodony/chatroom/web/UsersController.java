package com.dodony.chatroom.web;


import com.dodony.chatroom.bean.Users;
import com.dodony.chatroom.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/query")
    public Users testQuery() {
        return usersService.selectUserByName("235ca%");
    }

//    @RequestMapping("/insert")
//    public List<User> testInsert() {
//        userService.insertService();
//        return userService.selectAllUser();
//    }
//
//
//    @RequestMapping("/changemoney")
//    public List<User> testchangemoney() {
//        userService.changemoney();
//        return userService.selectAllUser();
//    }
//
//    @RequestMapping("/delete")
//    public String testDelete() {
//        userService.deleteService(3);
//        return "OK";
//    }

}
