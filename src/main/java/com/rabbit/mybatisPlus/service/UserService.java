package com.rabbit.mybatisPlus.service;

import com.rabbit.mybatisPlus.mapper.UserMapper;
import com.rabbit.mybatisPlus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * User实体不必把各个参数都写上，只需要写上需要插入的参数即可
     */
    public void insertUser() {
        User user = new User();
        user.setName("ttttttttttttttttttt");
        user.setAge(18);
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
    }

    /**
     * 删除用户
     * @param i 1.根据id删除 2.根据map删除 3.根据id集合删除
     *          1: DELETE FROM user WHERE id=?
     *             直接传入id即可。 返回值是影响行数
     *          2: DELETE FROM user WHERE name = ? AND age = ?
     *             传入map，key为数据库字段名，value为条件值。返回值是影响行数
     *          3: DELETE FROM user WHERE id IN ( ? , ? )
     *             传入id集合，返回值是影响行数
     */
    public void deleteUser(int i) {
        if (i == 1) {
            userMapper.deleteById("1692165662321512449");
        } else if (i == 2) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "rabbit");
            map.put("email", null);
            userMapper.deleteByMap(map);
        } else if (i == 3) {
            List<String> ids = Arrays.asList("1", "2");
            userMapper.deleteBatchIds(ids);
        }
    }


    /**
     * 更新用户
     * UPDATE user SET name=?, age=?, email=? WHERE id=?
     * 传入实体类，id为条件
     */
    public void updateUser() {
        User user = new User();
        user.setId("1692165662321512449");
        user.setName("sunzhen");
        user.setEmail("eee");
        userMapper.updateById(user);
    }

    /**
     * 选择用户
     *
     * @param i 我
     *          1.根据id查询 2.根据id集合查询 3.根据map查询
     *          1: SELECT id,name,age,email,create_time,update_time FROM user WHERE id=?
     *          直接传入id即可。 返回值是实体类
     *          2: SELECT id,name,age,email,create_time,update_time FROM user WHERE id IN ( ? , ? )
     *          传入id集合，返回值是实体类集合
     *          3: SELECT id,name,age,email,create_time,update_time FROM user WHERE name = ? AND email = ?
     *          传入map，key为数据库字段名，value为条件值。返回值是实体类集合
     */
    public void selectUser(int i) {
        if (i == 1) {
            User user = userMapper.selectById("1");
            System.out.println(user);
        } else if (i == 2) {
            List<String> ids = Arrays.asList("1", "2");
            List<User> users = userMapper.selectBatchIds(ids);
            System.out.println(users);
        } else if (i == 3) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "rabbit");
            map.put("email", "ssssssss");
            List<User> users = userMapper.selectByMap(map);
            System.out.println(users);
        }

    }



}
