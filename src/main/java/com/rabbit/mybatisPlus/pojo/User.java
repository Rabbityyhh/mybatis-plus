package com.rabbit.mybatisPlus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author rabbit
 */
@Data
@TableName("uuuser")// 用来实现表名和类名不一致的情况  映射
public class User {

    /**
     * tableId 用来实现主键不是id的情况 把加了tableId注解的字段设置为主键
     * 如果主键是id的话  可以不用加tableId注解
     * @TableId(type = IdType.AUTO)  表示主键自增
     * @TableId(type = IdType.INPUT) 表示主键手动输入
     * @TableId(type = IdType.NONE)  表示主键不自增
     * @TableId(type = IdType.UUID)  表示主键自动生成uuid
     * @TableId(type = IdType.ASSIGN_ID)  表示主键自动生成雪花算法字符串
     * @TableId(value = "id")  表示主键不是id的情况
     *  value:表示数据库中主键字段名 可以进行映射
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    /**
     * 用来实现字段和属性不一致的情况  表示该字段是数据库中的字段
     * @TableField(value = "age")  表示数据库中字段名
     * @TableField(exist = false)  表示该字段不是数据库中的字段 在执行sql语句的时候不会出现该字段
     */
    @TableField("age")
    private Integer age;

    /**
     * 用来实现字段和属性不一致的情况  表示该字段不是数据库中的字段
     */
    @TableField(exist = false)
    private String password;

    private String email;

    private String score;

    /**
     * 用来实现逻辑删除
     * @TableLogic 表示逻辑删除
     * 使用了这个注解之后  在执行删除操作的时候  会自动把is_delete字段的值改为1
     * 在查询时  会自动把is_delete字段的值改为0
     */
    @TableLogic
    @TableField(value = "is_delete")
    private String idDelete;

}
