package com.store.web;

import com.store.domain.Category;
import com.store.domain.Goods;
import com.store.service.ICategoryService;
import com.store.service.IGoodsService;
import com.store.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/GoodsEditUIServlet")
public class GoodsEditUIServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GoodsEditUIServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        //获取当前商品
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        Goods goods = null;
        try {
            goods = goodsService.getGoodsWith(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("goods",goods);
        //获取所有分类处理
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        List<Category> categories = null;
        try {
            categories = categoryService.findCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("allCategory",categories);
        request.getRequestDispatcher("/admin/edit.jsp").forward(request,response);
    }
}
