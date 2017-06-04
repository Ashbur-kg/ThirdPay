package com.zou.comsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/4.
 */
@Controller
public class HelloController {
    private String hello;

    @RequestMapping("/helloJsp")
    @ResponseBody
    public String helloJsp(Map<String, Object> map) {
        System.out.println("HelloController.helloJsp().hello=hello");
        hello = "helloworld";
        map.put("hello", hello);
        return "helloJsp";
    }
}

