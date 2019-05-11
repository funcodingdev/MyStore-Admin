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
import javax.xml.ws.Service;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        String name = request.getParameter("name");
//        String price = request.getParameter("price");
//        String cid = request.getParameter("cid");
//        String is_hot = request.getParameter("is_hot");
//        String image = request.getParameter("image");
//        String gdesc = request.getParameter("gdesc");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
//        goods.setName(name);
//        goods.setPrice(Double.valueOf(price));
//        goods.setCid(Integer.valueOf(cid));
//        goods.setGdesc(gdesc);
//        goods.setIs_hot(Integer.valueOf(is_hot));
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
            goodsService.addGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/GoodsListServlet").forward(request,response);
    }
}
