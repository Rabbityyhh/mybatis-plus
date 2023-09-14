package com.rabbit.mybatisPlus.differentImpl.service;

import com.rabbit.mybatisPlus.pojo.User;

/**
 * @author rabbit
 */
public interface TestService {

    /**
     * 获取用户信息
     *
     * @param user
     * @return UserInfo
     */
    String getUserInformation(User user);

}
