package com.store.web;

import com.store.domain.Goods;
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
import java.util.Collections;
import java.util.List;

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("GoodsListServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        List<Goods> allGoods = null;
        try {
            allGoods = goodsService.getAllGoods();
            //对集合进行反转
            Collections.reverse(allGoods);
            request.setAttribute("allGoods",allGoods);
            request.getRequestDispatcher("/admin/main.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
