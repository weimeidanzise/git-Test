package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(Integer id){
        System.out.println("hello mvc"+id);

        return "success";
    }
}
