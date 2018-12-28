package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping
public class AjaxController {
    public @ResponseBody String ajaxTest() {
        User user=new User();
        user.setUname("老王");
        System.out.println("ajaxTest方法执行了");
        System.out.println();
        return "ajaxText";
    }
}
