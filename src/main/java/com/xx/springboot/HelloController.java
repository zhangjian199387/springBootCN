package com.xx.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public final class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        Integer inter = 1;
        return "/loginModule/upload";
    }
}
