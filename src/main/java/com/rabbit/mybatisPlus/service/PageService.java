package com.rabbit.mybatisPlus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbit.mybatisPlus.mapper.UserMapper;
import com.rabbit.mybatisPlus.pojo.User;
import com.rabbit.mybatisPlus.pojo.UserAndScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  new Page<>(2,3) 中的参数，第一个参数是页码，第二个参数是每页条数。
     *                  eg：(2,3)  sql中执行的就是 limit 3,3
     *
     * .getTotal() 方法可以或者满足条件的所有的条数，非当前页的条数
     * .getPages() 可以获取满足条件的所有页数
     * .getRecords()  获取结果
     * .hasNext() 是否有下一页    返回的是 boolean
     */
    public void searchByPage() {
        Page<User> userPage = new Page<>(2,2);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, "rabbit");
        Page<User> userPage1 = userMapper.selectPage(userPage, lambdaQueryWrapper);
        long total = userPage1.getTotal();
        System.out.println(userPage1.getPages());
        System.out.println(total);
        System.out.println(userPage1);
    }

    /**
     * .getTotal()  可以获取总行数
     */
    public Page<UserAndScore> customSqlByPage() {
        Page<UserAndScore> page = new Page<>(2,3);
        userMapper.userAndScoreList(page);
        System.out.println(page.getTotal());
        return page;
    }

}
