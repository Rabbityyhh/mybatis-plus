package com.rabbit.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbit.mybatisPlus.pojo.User;

/**
 * @author rabbit
 * 继承service模式
 */
public interface UserServiceCRUD extends IService<User> {

    public void insertBySelect();

    public void insertUser();

    public void deleteUsearByList();

}
