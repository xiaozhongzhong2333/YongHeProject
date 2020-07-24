package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.dao.OrderDao;
import com.zb.pojo.Door;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/orderAdd")
public class OrderInsertServlet extends HttpServlet {
    // doorId orderNo orderType pnum cashier payType price
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        OrderDao orderDao = new OrderDao();
        String door_name = request.getParameter("doorId");
        int door_id = 0;
        try {
            door_id = orderDao.find_Door_id(door_name);
            System.out.println("id为"+door_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String orderNo = request.getParameter("orderNo");
        String orderType = request.getParameter("orderType");
        int pnum = Integer.parseInt(request.getParameter("pnum"));
        String cashier = request.getParameter("cashier");
        String payType = request.getParameter("payType");
        double price = Double.parseDouble(request.getParameter("price"));
        Date order_time = new Date();
        Date pay_time = new Date();

        Order order = new Order(door_id, orderNo, orderType, pnum,
                cashier, order_time, pay_time, payType, price);
        try {
            int result = orderDao.addOrder(order);
            request.setAttribute("list", orderDao.findAll());
            request.getRequestDispatcher("" + request.getContextPath() + "/order_list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
