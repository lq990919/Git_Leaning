package com.hr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hr.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lq
 * @date 2021-07-19 - 9:17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
