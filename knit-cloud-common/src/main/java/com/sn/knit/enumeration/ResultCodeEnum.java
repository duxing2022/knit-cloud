package com.sn.knit.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Code枚举
 *
 * @author Administrator
 * @date 2022/06/19
 */

@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS("00000", "SUCCESS"),

    /**
     * 失败
     */
    FAIL("11111", "ERROR");

    /**
     * 错误码
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String message;


}
