package com.sn.knit.advice;

import com.sn.knit.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 全局异常通知
 *
 * @author Administrator
 * @date 2022/06/16
 */


@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 处理全局异常
     *
     * @param request   请求
     * @param exception 异常
     * @return {@link CommonResponse}<{@link String}>
     */
    public CommonResponse<String> handleGlobalException(MultipartHttpServletRequest request,
            Exception exception) {

        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(exception.getMessage());
        log.error("commerce service has error: [{}]", exception.getMessage(), exception);

        return response;
    }
}
