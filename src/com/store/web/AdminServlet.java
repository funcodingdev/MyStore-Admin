package com.store.web;

import com.store.domain.Admin;
import com.store.service.IAdminService;
import com.store.service.ServiceFactory;
import com.store.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        System.out.println("AdminServlet");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+":"+password);
        IAdminService adminService = ServiceFactory.getAdminService();
        Admin admin = null;
        try {
            admin = adminService.login(username,password);
//            System.out.println("登陆成功");
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
        } catch (Exception e) {
            if(e.getMessage().equals("用户名或密码错误")){
                //跳转回登陆页面，回显错误信息
                request.setAttribute("err",e.getMessage());
                request.getRequestDispatcher("/admin/admin_login.jsp").forward(request,response);
            }else{
                e.printStackTrace();
            }
        }
    }
}
