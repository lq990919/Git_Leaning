package com.hr.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
/**
 * @author lq
 * @date 2021-06-12 - 16:12
 */
@Data
public class R {
    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    public R(){}


    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功啊");
        return r;
    }


    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }


    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
