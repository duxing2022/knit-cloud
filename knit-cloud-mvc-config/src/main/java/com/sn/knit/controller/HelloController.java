package com.sn.knit.controller;

import com.sn.knit.vo.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ssh
 * @version 1.0
 * @date 2022/5/14 18:26
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public CommonResponse hello(){
        return new CommonResponse(0000,"hello");
    }
}
