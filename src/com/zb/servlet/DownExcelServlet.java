package com.zb.servlet;

import com.zb.utils.ExcelPOI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/downExcel")
public class DownExcelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个流 将生成的excel发回给浏览器  让浏览器下载
        ServletOutputStream servletOut=response.getOutputStream();
        //设置头文件 让浏览器下载
        response.setHeader("Content-Disposition","attachment;fileName=studentList.xls");
        //预先设置表头
        String [] titles={"编号","学生姓名"};
        //利用POI生成Excel  调用ExcelPOI（自定义方法）
        ExcelPOI excelPOI=new ExcelPOI();
        try {
            excelPOI.exportExcel(titles,servletOut);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
