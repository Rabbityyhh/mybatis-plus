package com.rabbit.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbit.mybatisPlus.dto.Score;
import com.rabbit.mybatisPlus.service.ScoreService;
import com.rabbit.mybatisPlus.mapper.ScoreMapper;
import org.springframework.stereotype.Service;

/**
* @author rabbit
* @description 针对表【score】的数据库操作Service实现
* @createDate 2023-09-06 22:32:58
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{

}




