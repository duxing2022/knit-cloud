package com.sn.knit.advice;

import com.sn.knit.constant.CommonConstant;
import com.sn.knit.vo.CommonResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常通知
 *
 * @author Administrator
 * @date 2022/06/16
 */

//@RestControllerAdvice都是对Controller进行增强的，可以全局捕获spring mvc抛的异常。
//@ExceptionHandler(value = Exception.class) ExceptionHandler的作用是用来捕获指定的异常。

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    // @ExceptionHandler 拦截了异常，我们可以通过该注解实现自定义异常处理。

    /**
     * 处理全局异常
     *
     * @param request   请求
     * @param exception 异常
     * @return {@link CommonResponse}<{@link String}>
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handleGlobalException(HttpServletRequest request,
            Exception exception) {

        CommonResponse<String> response = new CommonResponse<>(CommonConstant.ERROR_CODE,
                "business error");
        response.setData(exception.getMessage());
        log.error("commerce service has error: [{}]", exception.getMessage(), exception);

        return response;
    }
}
