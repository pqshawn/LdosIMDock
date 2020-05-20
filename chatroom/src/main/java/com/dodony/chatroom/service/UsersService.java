package com.dodony.chatroom.service;

import com.dodony.chatroom.bean.Users;
import com.dodony.chatroom.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;

    /**
     * 根据名字查找用户
     */
    public Users selectUserByName(String name) {
        return usersDao.findUserByName(name);
    }


//    /**
//     * 查找所有用户
//     */
//    public List<User> selectAllUser() {
//        return userDao.findAllUser();
//    }
//
//    /**
//     * 插入两个用户
//     */
//    public void insertService() {
//        userDao.insertUser("SnailClimb", 22, 3000.0);
//        userDao.insertUser("Daisy", 19, 3000.0);
//    }
//
//    /**
//     * 根据id 删除用户
//     */
//
//    public void deleteService(int id) {
//        userDao.deleteUser(id);
//    }
//
//    /**
//     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
//     */
//    @Transactional
//    public void changemoney() {
//        userDao.updateUser("SnailClimb", 22, 2000.0, 3);
//        // 模拟转账过程中可能遇到的意外状况
//        int temp = 1 / 0;
//        userDao.updateUser("Daisy", 19, 4000.0, 4);
//    }

}
