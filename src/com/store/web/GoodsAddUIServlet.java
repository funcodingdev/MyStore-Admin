package com.store.web;

import com.store.domain.Category;
import com.store.service.ICategoryService;
import com.store.service.IGoodsService;
import com.store.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/GoodsAddUIServlet")
public class GoodsAddUIServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GoodsAddUIServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        List<Category> categories = null;
        try {
            categories = categoryService.findCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(categories);
        request.setAttribute("allCategory",categories);
        request.getRequestDispatcher("/admin/add.jsp").forward(request,response);
    }
}
