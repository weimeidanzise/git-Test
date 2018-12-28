package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //完成方法分发 获取请求路径
        String uri = request.getRequestURI();

        //根据uri获取方法名称
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        //获取方法
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //将传入的对象序列化为json  写回客户端
    public void writeValue(Object obj, HttpServletResponse response) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), obj);
    }

    public String writeValueAsString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }


}
