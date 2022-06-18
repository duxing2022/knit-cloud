package com.sn.knit.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * HelloController
 *
 * @author Administrator
 * @date 2022/06/18
 */
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
