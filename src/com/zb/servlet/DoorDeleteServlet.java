package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/doorDelete")
public class DoorDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DoorDao doorDao=new DoorDao();
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("删除id"+id);
        try {
            int result=doorDao.delDoor(id);
                request.setAttribute("list", doorDao.findAll());
                request.getRequestDispatcher(""+request.getContextPath()+"/door_list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
