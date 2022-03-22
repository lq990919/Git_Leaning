package com.hr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.entity.User;

import java.util.List;

/**
 * @author lq
 * @date 2021-07-19 - 9:15
 */
public interface UserService extends IService<User> {

    void add(User user);
    void update(User user);
    void deleted(int id);
    //分页
    List<User> list(int current ,int size);
    User selUserById(int id);

    List<User> multiQueryByPo(String userName,String userAddress);


}
