package com.rabbit.mybatisPlus.mapper;
import org.apache.ibatis.annotations.Param;

import com.rabbit.mybatisPlus.dto.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author rabbit
* @description 针对表【score】的数据库操作Mapper
* @createDate 2023-09-06 22:32:58
* @Entity com.rabbit.mybatisPlus.dto.Score
 *
 *
 *
 * 在继承了BaseMapper的mapper中，写带有 insert delete update select
 * 的方法，可以通过 alt+enter 来使用mybatisX自动生成xml中的sql语句
 *
*/
public interface ScoreMapper extends BaseMapper<Score> {

    int insertSelective(Score score);

}




