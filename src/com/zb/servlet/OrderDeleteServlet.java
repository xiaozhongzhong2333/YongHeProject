package com.zb.servlet;

import com.zb.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/orderDelete")
public class OrderDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        OrderDao orderDao=new OrderDao();
        try {
            int result=orderDao.delOrder(id);
            request.setAttribute("list", orderDao.findAll());
            request.getRequestDispatcher("" + request.getContextPath() + "/order_list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
