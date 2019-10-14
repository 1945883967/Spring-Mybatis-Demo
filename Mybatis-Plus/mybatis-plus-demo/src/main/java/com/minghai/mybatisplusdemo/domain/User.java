package com.minghai.mybatisplusdemo.domain;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

//@TableName("mp_user")
@Data
public class User {
    @TableId
    private Long id;
    @TableField(value = "name",condition = SqlCondition.LIKE)
    private String realName;
    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;

    // 备注
//    private transient String reamrk;
//    private static String reamrk;

//    @TableField(exist = false)
//    private static String reamrk;

}