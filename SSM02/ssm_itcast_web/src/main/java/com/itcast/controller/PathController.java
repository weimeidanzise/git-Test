package com.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathController {

    @RequestMapping("/pathName/{name}")
    public String path(@PathVariable("name") String pname){
        return pname;
    }
}
