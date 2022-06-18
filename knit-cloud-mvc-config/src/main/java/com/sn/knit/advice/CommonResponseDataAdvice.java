package com.sn.knit.advice;

import com.sn.knit.annotation.IgnoreResponseAdvice;
import com.sn.knit.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 通用响应数据通知
 *
 * @author Administrator
 * @date 2022/06/16
 */

@RestControllerAdvice(value = "com.sn.knit")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要对响应进行处理
     *
     * @param methodParameter 方法参数
     * @param aClass          clazz
     * @return boolean
     */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter,
            Class<? extends HttpMessageConverter<?>> aClass) {

        // 判断是否要执行beforeBodyWrite方法,true为执行,false不执行.
        // 通过该方法可以选择哪些类或那些方法的response要进行处理, 其他的不进行处理.
        if (methodParameter.getDeclaringClass()
                .isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        return true;
    }

    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        // 定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");

        if (null == o) {
            return response;
        } else if (o instanceof CommonResponse) {
            response = (CommonResponse<Object>) o;
        } else {
            response.setData(o);
        }

        return response;
    }
}
