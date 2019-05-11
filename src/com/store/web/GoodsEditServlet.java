package com.store.web;

import com.store.domain.Goods;
import com.store.service.IGoodsService;
import com.store.service.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/GoodsEditServlet")
public class GoodsEditServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GoodsEditServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        goods.setImage("goods_001.png");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        try {
            goodsService.updateGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/GoodsListServlet").forward(request,response);
    }
}
