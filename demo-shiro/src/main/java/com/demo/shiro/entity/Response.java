package com.demo.shiro.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应数据
 */
public class Response extends HashMap<String, Object> {


    /**
     * 信息
     * @param message
     * @return
     */
    public Response message(String message){

        this.put("message", message);

        return this;
    }

    /**
     * 数据
     * @param data
     * @return
     */
    public Response data(Object data){

        this.put("data", data);

        return this;
    }

    /**
     * 重新方法
     * @param key
     * @param value
     * @return
     */
    @Override
    public Object put(String key, Object value) {

        super.put(key, value);

        return this;
    }
}
