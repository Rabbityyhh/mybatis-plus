package com.rabbit.mybatisPlus.differentImpl.service.impl;

import com.rabbit.mybatisPlus.differentImpl.service.TestService;
import com.rabbit.mybatisPlus.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author rabbit
 */
@Service("serviceB")
public class TestServiceImpl02 implements TestService {


    @Override
    public String getUserInformation(User user) {
        return "这是第二个实现类";
    }


}
