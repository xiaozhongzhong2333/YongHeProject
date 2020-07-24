package com.zb.servlet;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.zb.dao.DoorDao;
import com.zb.dao.OrderDao;
import com.zb.pojo.Door;
import com.zb.pojo.JsonResult;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页
        Integer pageOn = Integer.parseInt(request.getParameter("page"));
        //每页显示几条
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        System.out.println("订单管理");
        OrderDao orderDao = new OrderDao();
        System.out.println("开始门店操作");
        List<Order> list = orderDao.dopage(pageOn, pageSize);
        System.out.println("list+" + list);
        Integer count = orderDao.pagecount();
        System.out.println("count为" + count);
        JsonResult jr = new JsonResult(0, "success", count, list);
        System.out.println(jr);
        Gson gson = new Gson();
        String json = gson.toJson(jr);
        System.out.println("json"+json);
        response.getWriter().write(json);
    }
}
