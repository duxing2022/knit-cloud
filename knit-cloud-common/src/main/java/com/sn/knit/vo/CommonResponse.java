package com.sn.knit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * 通用响应对象定义
 * {
 * "code":0,
 * "message": "",
 * "data":{}
 * }
 *
 * @author ssh
 * @version 1.0
 * @date 2022/4/21 22:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {


    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 泛型响应数据
     */
    private T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static CommonResponse success(int i, String 登录成功, Map<String, String> map) {
    }
}
