package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();
    ResultInfo info = new ResultInfo();
    private User user=new User();
    public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //先校验
        String check = request.getParameter("check");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {

            info.setErrorMsg("验证码错误");
            info.setFlag(false);
            //序列化写回客户端
            writeValue(info,response);
        }
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = service.regist(user);
        if (flag) {
            info.setFlag(true);

        } else {
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }

            writeValue(info, response);


    }
    public void login(HttpServletRequest request,HttpServletResponse response) throws Exception {

        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User u = service.login(user);
        if (u==null){
            info.setErrorMsg("用户名或密码错误");
            info.setFlag(false);
        }
        if (u!=null &&!"Y".equals(u.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您尚未激活 请激活");
        }
        if (u!=null && "Y".equals(u.getStatus())){
            info.setFlag(true);
            request.getSession().setAttribute("user",u);
        }
        writeValue(info,response);
    }
    public void exit(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
    public void active(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String code = request.getParameter("code");
       /* if (code!=null){
            boolean flag = service.active(code);
            String msg=null;
            if (flag){
                msg="激活成功，请<a href='http://localhost/travel/login.html'>登录</a>";
            }
            else{
              msg="激活失败 请联系管理员";
            }
        }*/
        boolean flag = service.active(code);
        String msg=null;
        if (flag){
            msg="激活成功,请<a href='http://localhost/travel/login.html'>登录</a>";
        }else{
            msg="激活失败 请联系管理员";
        }
        writeValue(msg,response);
    }

    public void findOne(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Object user = request.getSession().getAttribute("user");
        writeValue(user,response);
    }
}
