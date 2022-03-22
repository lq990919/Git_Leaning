package com.hr.controller;

import com.hr.entity.User;
import com.hr.service.UserService;
import com.hr.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author lq
 * @date 2021-07-19 - 9:02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


//    @RequestMapping("/list")
//    @ResponseBody
//    public R list(
//            @RequestParam(value = "page") int current,
//            @RequestParam(value = "limit") int size){
//        List<User> list = userService.list(current,size);
//        System.out.println(list);
//
//        return R.ok().data("list",list);
//    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(int page,int limit){
        List<User> list = userService.list(page,limit);
        System.out.println(list);

        return R.ok().data("list",list);
    }


    @RequestMapping("/sel")
    @ResponseBody
    public R selByUser(String userName,String userAddress){

        System.out.println(userName);
        System.out.println(userAddress);

        List<User> ulist = userService.multiQueryByPo(userName, userAddress);

        return R.ok().data("list",ulist);
    }


    @RequestMapping("/login")
    public String login(){
        return "list";
    }

    @RequestMapping("/index")
    public String demo(){
        return "index";
    }

}
