package com.sn.knit.vo;

import com.sn.knit.enumeration.ResultCodeEnum;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应对象
 *
 * @author Administrator
 * @date 2022/06/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    /**
     * code
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 泛型响应数据
     */
    private T data;

    public CommonResponse(ResultCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public CommonResponse(ResultCodeEnum codeEnum, T data) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        this.data = data;
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse<>(ResultCodeEnum.SUCCESS);
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> CommonResponse<T> error() {
        return new CommonResponse<>(ResultCodeEnum.FAIL);
    }

    public static <T> CommonResponse<T> error(T data) {
        return new CommonResponse<>(ResultCodeEnum.FAIL, data);
    }
}
