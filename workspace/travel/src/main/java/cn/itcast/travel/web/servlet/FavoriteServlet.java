package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/favoriteServlet/*")
public class FavoriteServlet extends HttpServlet {
    public void favorite(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
