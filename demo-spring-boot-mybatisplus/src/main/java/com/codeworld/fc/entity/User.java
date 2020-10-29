package com.codeworld.fc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName User
 * Description TODO
 * Author Lenovo
 * Date 2020/10/29
 * Version 1.0
**/
@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;
}
