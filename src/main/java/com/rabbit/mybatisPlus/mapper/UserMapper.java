package com.rabbit.mybatisPlus.mapper;
import java.util.Collection;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbit.mybatisPlus.pojo.User;
import com.rabbit.mybatisPlus.pojo.UserAndScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户映射器
 *
 * @author rabbit
 * @date 2023/08/15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<UserAndScore> userAndScoreList(@Param("page") Page<UserAndScore> page);

    int insertBatch(@Param("userCollection") Collection<User> userCollection);

}
