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

@WebServlet("/doorAdd")
public class DoorAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DoorDao doorDao=new DoorDao();
        String name=request.getParameter("name");
        String tel=request.getParameter("tel");
        String addr=request.getParameter("addr");
        Door door=new Door(name,tel,addr);
        try {
            int result=doorDao.addDoor(door);
            request.setAttribute("list",doorDao.findAll());
            request.getRequestDispatcher(""+request.getContextPath()+"/door_list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
