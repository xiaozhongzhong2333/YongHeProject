package com.zb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DoEditor")
public class DoEditorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String editorDate=request.getParameter("content");
        System.out.println(editorDate);
        request.setAttribute("editorDate",editorDate);
        request.getRequestDispatcher("/daily.jsp").forward(request,response);
    }
}
