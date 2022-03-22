package com.hr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author lq
 * @date 2021-07-19 - 9:04
 */
@Data
public class User {

    @TableId(value = "userId",type = IdType.AUTO)
    private int userId;
    private String userDate;
    private String userName;
    private String userAddress;

}
