package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/showsale")
public class ShowSaleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ShowSale 接受请求");
        response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        DoorDao doorDao=new DoorDao();
        try {
            List<Door>  list=doorDao.showSale();
            System.out.println(list);
            Gson gson=new Gson();
            String json=gson.toJson(list);
            System.out.println(json);
            //通过输出流返回给浏览器
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
