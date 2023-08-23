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

    @Override
    public void insertBySelect() {
        List<User> list = this.list();
        System.out.println(list);
        list.forEach(item -> {
            if (!"1".equals(item.getId())) {
                item.setId(item.getId() + "10");
            }
        });
        this.saveOrUpdateBatch(list);

    }
}
