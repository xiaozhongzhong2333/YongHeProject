package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/doorlist")
public class DoorListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("门店管理");
        DoorDao doorDao=new DoorDao();
        try {
           List<Door> list= doorDao.findAll();
           request.setAttribute("list",list);
            System.out.println(request.getContextPath().toString());
            System.out.println("1");
           request.getRequestDispatcher(""+request.getContextPath()+"/door_list.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
