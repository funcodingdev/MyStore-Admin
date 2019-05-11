package com.store.web;

import com.store.domain.Goods;
import com.store.service.IGoodsService;
import com.store.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GoodsDelServlet")
public class GoodsDelServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GoodsDelServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        try {
            goodsService.deleteGoods(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/GoodsListServlet").forward(request, response);
    }
}
