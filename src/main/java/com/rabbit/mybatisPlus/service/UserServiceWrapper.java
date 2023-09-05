package com.rabbit.mybatisPlus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.rabbit.mybatisPlus.mapper.UserMapper;
import com.rabbit.mybatisPlus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author rabbit
 */
@Service
public class UserServiceWrapper {

    @Autowired
    private UserMapper userMapper;

    /**
     * 条件构造器创建查询条件
     * SELECT id,name,age,email,score,is_delete AS idDelete FROM uuuser WHERE is_delete='0' AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
     * 只要在实体类中配置了 TableLogic 在查询数据库时，会自动增加 is_delete = 0 这个操作
     *
     * 每个流式方法的第一个条件condition  true ：拼接这个条件。false：不拼接这个条件
     *          使用场景就是，看这个值是否为空，空的话就不插入了
     */
    public void queryUserByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "rab")
                .between(true,"age", 100, 500)
                .isNotNull("email");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    public void updateByWrapper() {
        User user = new User();
        user.setName("小七");
        user.setAge(2);
        user.setEmail("xiaoqi@qq.com");
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name","Jack")
                .like("id", 21);

        // or() 方法是或者的意思，如果条件上有或者的话，可以添加or来完成
//        wrapper.eq("name","Jack")
//                .like("id", 21)
//                .or()
//                .isNotNull("email");

        userMapper.update(user, wrapper);
    }

    /**
     * 将名字中包含 sun 并且 （年龄大于20或者邮箱是null）的数据进行修改
     *
     * .and 中的内容会优先执行  相当于一个()
     *      里面是一个lambda表达式， t就代表wrapper
     *
     *      当然 .or() 中也可以这么写  相当于或者()
     *  UpdateWrapper 在修改操作时，可以更快捷
     */
    public void orAndAndUpdate() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "sun")
                .and(t -> t.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("yinhao");
        userMapper.update(user, wrapper);
        // 以上的代码可以使用UpdateWrapper 更快捷的进行
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("name", "sun")
                .and(t -> t.gt("age", 20).or().isNull("email"));
        userUpdateWrapper.set("name","yinhao").set("sex", 1);
        userMapper.update(null, userUpdateWrapper);
    }

    /**
     * 组装select语句，  不查询全部的字段，只查询我们需要的字段
     */
    public void selectBySelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        System.out.println(maps);
    }

    public void lambdaWrapper() {
        String name = "七七";
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(name), User::getName, name)
                .gt(User::getAge, 20);

    }


}
