package com.codeworld.fc.xxl.response;

import lombok.Data;

/**
 * ClassName FcResponse
 * Description TODO
 * Author Lenovo
 * Date 2021/1/22
 * Version 1.0
**/
@Data
public class FcResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public FcResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
