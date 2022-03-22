package com.hr.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hr.entity.User;
import com.hr.mapper.UserMapper;
import com.hr.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author lq
 * @date 2021-07-19 - 9:16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public void add(User user) {
        baseMapper.insert(user);
    }

    @Override
    public void update(User user) {
        baseMapper.updateById(user);
    }

    @Override
    public void deleted(int id) {
        baseMapper.deleteById(id);
    }

    @Override
    public List<User> list(int current ,int size) {
        IPage<User> userIPage = new Page<>(current,size);
        userIPage = baseMapper.selectPage(userIPage, null);
        List<User> ulist = userIPage.getRecords();
        System.out.println(ulist);
        return ulist;
    }

    @Override
    public User selUserById(int id) {
        return baseMapper.selectById(id);
    }


    /**
     * 分页功能
     * @param userName
     * @param userAddress
     * @return
     */
    @Override
    public List<User> multiQueryByPo(String userName,String userAddress) {

        if(StringUtils.hasText(userName) && !StringUtils.hasText(userAddress)){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("userName",userName);
            return baseMapper.selectList(queryWrapper);
        }else if (StringUtils.hasText(userAddress) && !StringUtils.hasText(userName)){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("userAddress",userAddress);
            baseMapper.selectList(queryWrapper);
            return baseMapper.selectList(queryWrapper);
        }else if(StringUtils.hasText(userName) && StringUtils.hasText(userAddress)){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("userName",userName);
            queryWrapper.like("userAddress",userAddress);
            return baseMapper.selectList(queryWrapper);
        }else{
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.last("limit 0,10");
            return baseMapper.selectList(queryWrapper);
        }
    }
}
