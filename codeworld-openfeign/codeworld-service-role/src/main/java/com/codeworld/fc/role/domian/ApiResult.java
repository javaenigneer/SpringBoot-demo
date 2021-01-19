package com.codeworld.fc.role.domian;

import lombok.Data;

/**
 * ClassName ApiResult
 * Description TODO
 * Author Lenovo
 * Date 2021/1/19
 * Version 1.0
**/
@Data
public class ApiResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public ApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
