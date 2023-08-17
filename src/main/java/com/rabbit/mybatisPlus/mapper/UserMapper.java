package com.rabbit.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rabbit.mybatisPlus.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户映射器
 *
 * @author rabbit
 * @date 2023/08/15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
