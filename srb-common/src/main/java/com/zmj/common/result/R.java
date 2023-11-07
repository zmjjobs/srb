package com.zmj.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : mjzhud
 * @create 2023/11/7 21:03
 */
@Data
public class R<T> {
    /** 响应状态码 */
    private Integer code;
    /** 响应信息 */
    private String message;
    private Map<String,T> data = new HashMap<>();

    private R(){}

    /**
     * 返回成功结果
     * @return
     */
    public static R ok(){
        R r = new R();
        r.setCode(RespnoseEnum.SUCCESS.getCode());
        r.setMessage(RespnoseEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 返回错误结果
     * @return
     */
    public static R error(){
        R r = new R();
        r.setCode(RespnoseEnum.ERROR.getCode());
        r.setMessage(RespnoseEnum.ERROR.getMessage());
        return r;
    }

    /**
     * 设置特定结果
     * @return
     */
    public static R setResult(RespnoseEnum respnoseEnum){
        R r = new R();
        r.setCode(respnoseEnum.getCode());
        r.setMessage(respnoseEnum.getMessage());
        return r;
    }

    public R data(String key,T value){
        this.data.put(key,value);
        return this;
    }

    public R data(Map<String,T> map){
        this.setData(map);
        return this;
    }

    /**
     * 设置特定的消息
     * @param message
     * @return
     */
    public R message(String message){
        this.setMessage(message);
        return this;
    }

    /**
     * 设置特定的响应码
     * @param code
     * @return
     */
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
}
