package com.store.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    public static final String REDIRECE = "redirect";
    public static final String DISPATCHER = "dispatcher";

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
//        System.out.println("action:"+action);
        try {
            //获取当前类的字节码
            Class clazz = this.getClass();
            Method method = null;
            String desPath = null;
            method = clazz.getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            desPath = (String) method.invoke(this, request, response);
//            System.out.println("action:"+action+",desPath:"+desPath);
            if(desPath != null){
                String[] split = desPath.split(":");
                if(REDIRECE.equals(split[0])){
                    response.sendRedirect(split[1]);
                }else if(DISPATCHER.equals(split[0])){
                    request.getRequestDispatcher(split[1]).forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
