package com.itcast.controller;

import com.itcast.domain.Pages;
import com.itcast.domain.User;
import com.itcast.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 作业：
 * 1.修改用户信息
 * 2.批量删除
 * 3.分页查询
 * 4.条件查询（两个以上）
 */


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session, Integer ck, User user, HttpServletResponse response) throws Exception {
        User user1 = userService.findUser(user);

        if (user1 != null) {
            session.setAttribute("user", user1);
            Cookie cookieName = new Cookie("username", user1.getUsername());
            Cookie cookiePwd = new Cookie("pwd", user1.getPwd());
            if (ck != null && ck == 1) {
                cookieName.setMaxAge(70 * 24 * 60 * 60);
                cookiePwd.setMaxAge(70 * 24 * 60 * 60);

            } else {
                cookieName.setMaxAge(0);
                cookiePwd.setMaxAge(0);
            }
            cookieName.setPath("/");
            cookiePwd.setPath("/");
            response.addCookie(cookieName);
            response.addCookie(cookiePwd);


            return "index1";
        }
        return "loginError";


    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id) throws Exception {
        userService.deleteUser(id);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "pageCounts", defaultValue = "3") Integer pageCounts) throws Exception {
        Pages pages=new Pages();
        pages.setPageNum(pageNum);
        pages.setPageCounts(pageCounts);
        List<User> list=userService.findAll(null);
        Integer counts=list.size();

        List<User> userList = userService.findAll(pages);
        pages.setCounts(counts);
        Integer page= counts%pageCounts==0?counts/pageCounts:counts/pageCounts+1;
        pages.setPages(page);

        model.addAttribute("userList",userList);
        model.addAttribute("pages",pages);

        return "list";

    }

    @RequestMapping("/saveUser")
    public String saveUser(User user) throws Exception {
        userService.saveUser(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Integer id) throws Exception {
        User user = userService.updateUser(id);
        return "redirect:user/findAll";

    }

   /* @RequestMapping("findPages")
    public String findPages(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(name = "pageCounts", defaultValue = "3") Integer pageCounts, Model model) throws Exception {
        Pages pages = new Pages();
        pages.setPageNum(pageNum);
        pages.setCounts(pageCounts);
        List<User> list = userService.findPages(null);
        int counts = list.size();

        List<User> userList = userService.findPages(pages);
        pages.setCounts(counts);
        Integer page = counts % pageCounts == 0 ? counts / pageCounts : counts / pageCounts + 1;
        pages.setPages(page);

        model.addAttribute("userList", userList);
        model.addAttribute("pages", pages);
        return "list";
    }*/

}
