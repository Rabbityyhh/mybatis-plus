package com.rabbit.mybatisPlus.service;

import com.rabbit.mybatisPlus.mapper.UserMapper;
import com.rabbit.mybatisPlus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 *
 * @author rabbit
 * @date 2023/08/15
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询全部
     */
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }

    /**
     * 单个插入，id生成方法为雪花算法，并且会自动返回
     */
    public void insertUser() {
        User user = new User();
        user.setName("rabbit");
        user.setAge(18);
        user.setEmail("ssssssss");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
    }


}
