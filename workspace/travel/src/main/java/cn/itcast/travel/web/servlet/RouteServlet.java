package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeservice = new RouteServiceImpl();
    private FavoriteService service = new FavoriteServiceImpl();

    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rid = request.getParameter("rid");
        //获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }
        boolean flag = service.isFavorite(rid, uid);
        writeValue(flag, response);
    }

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");
        if (rname != null) {

            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }


        int cid = 0;//类别id
        //2.处理参数
        if (cidStr != null && cidStr.length() > 0 && !"".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeservice.pageQuery(cid, currentPage, pageSize, rname);

        //4. 将pageBean对象序列化为json，返回
        writeValue(pb, response);

    }


}
