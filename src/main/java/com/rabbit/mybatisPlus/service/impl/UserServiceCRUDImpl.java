package com.rabbit.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbit.mybatisPlus.mapper.UserMapper;
import com.rabbit.mybatisPlus.pojo.User;
import com.rabbit.mybatisPlus.service.UserServiceCRUD;
import org.springframework.stereotype.Service;

/**
 * @author rabbit
 */
@Service
public class UserServiceCRUDImpl extends ServiceImpl<UserMapper, User> implements UserServiceCRUD {

}
