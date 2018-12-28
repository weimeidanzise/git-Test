package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class UserCont {
    @RequestMapping(path = "/findUser")
    public String findUser() {
        System.out.println("查询了用户aaa");
        return "success";
    }

    @RequestMapping("/findsucc")
    public ModelAndView testModelAndView() {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setAge(15);
        user.setUname("老大");
        mv.setViewName("success");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(path = "/forwardAndRedirect")
    public String forwardAndRedirect() {
        System.out.println("请求或转发执行");

        return "forward:/pages/success.jsp";
//        return "redirect:/index.jsp";
    }

    /* @RequestMapping("/testAjax")
     public @ResponseBody User testAjax(@RequestBody User user) {
         System.out.println("textAjax执行了");
         System.out.println(user);
         user.setUname("老张");
         System.out.println(user);

         return user;
 //        return "redirect:/index.jsp";


     }*/
    @RequestMapping("/testAjax")
    public @ResponseBody List<User> testAjax(@RequestBody User user2) {
        List<User> list=new ArrayList<>();
        System.out.println("textAjax执行了");
        User user = new User();
        user.setUname("呵呵");
        user.setAge(11);

        User user1 = new User();
        user1.setUname("哈哈");
        user1.setAge(12);
        list.add(user);
        list.add(user1);
        System.out.println(user);
        System.out.println(user1);
        return list;
//        return "redirect:/index.jsp";


    }


}