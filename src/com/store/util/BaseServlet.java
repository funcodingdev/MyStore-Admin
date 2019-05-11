package com.store.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        try {
            //获取当前类的字节码
            Class clazz = this.getClass();
            Method method = null;
            String desPath = null;
            method = clazz.getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            desPath = (String) method.invoke(this, request, response);
            System.out.println("action:"+action+",desPath:"+desPath);
            if(desPath != null){
                request.getRequestDispatcher(desPath).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
