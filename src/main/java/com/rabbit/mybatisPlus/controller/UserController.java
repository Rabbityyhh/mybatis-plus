package com.rabbit.mybatisPlus.controller;

import com.rabbit.mybatisPlus.pojo.User;
import com.rabbit.mybatisPlus.service.UserServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.mybatisPlus.service.UserService;

import java.util.List;

/**
 * 用户控制器
 *
 * @author rabbit
 * @date 2023/08/15
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceCRUD userServiceCRUD;

    @GetMapping("/selectAll")
    public List<User> selectAll() {
        return userService.selectAll();
    }

    @GetMapping("/insertUser")
    public void insertUser() {
        userService.insertUser();
    }

    @GetMapping("/deleteUser/{num}")
    public void deleteUser(@PathVariable("num") Integer num) {
        userService.deleteUser(num);
    }

    @GetMapping("/updateUser")
    public void updateUser() {
        userService.updateUser();
    }

    @GetMapping("/selectUser/{i}")
    public void selectUser(@PathVariable("i") Integer i) {
        userService.selectUser(i);
    }

    @GetMapping("/selectCount")
    public void selectCount() {
        long count = userServiceCRUD.count();
        System.out.println(count);
    }

}
