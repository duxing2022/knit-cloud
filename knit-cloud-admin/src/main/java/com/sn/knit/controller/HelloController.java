package com.sn.knit.controller;

import com.sn.knit.constant.CommonConstant;
import com.sn.knit.vo.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author Administrator
 * @date 2022/06/18
 */

@RestController
public class HelloController {


    @GetMapping("/hello")
    public CommonResponse<String> hello() throws Exception {
        return new CommonResponse<>(CommonConstant.SUCCESS_CODE, "hello");
    }
}
