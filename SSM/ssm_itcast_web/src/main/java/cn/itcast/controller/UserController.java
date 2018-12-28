package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll() throws Exception {
        List<User> userList = userService.findAll();
        System.out.println(userList.size());
        System.out.println("666666666666666666666666666666666666");
        return "";
    }
}
