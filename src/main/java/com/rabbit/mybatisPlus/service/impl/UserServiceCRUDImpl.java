package com.rabbit.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbit.mybatisPlus.mapper.UserMapper;
import com.rabbit.mybatisPlus.pojo.User;
import com.rabbit.mybatisPlus.service.UserServiceCRUD;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rabbit
 */
@Service
public class UserServiceCRUDImpl extends ServiceImpl<UserMapper, User> implements UserServiceCRUD {

    /**
     * 通过select插入
     */


    @Override
    public void insertBySelect() {
        List<User> list = this.list();
        System.out.println(list);
        list.forEach(item -> {
            if (!"1".equals(item.getId())) {
                item.setId(item.getId() + "10");
            }
        });
        saveOrUpdateBatch(list);

    }

    public void insertUser() {
        User user = new User();
        // 如何设置了id，就会根据设置的id去插入，没设置的话会用雪花算法自动生成。在实体类当中也可以设置主键生成策略
        // 在配置文件中同样可以设置主键生成策略
        user.setName("ceshi0824");
        user.setAge(18);
        user.setEmail("ceshi0824");
        user.setPassword("ceshi0824");
        user.setScore("123");
        save(user);
    }

    public void deleteUsearByList() {
        removeByIds(List.of("1", "2"));
    }
}
