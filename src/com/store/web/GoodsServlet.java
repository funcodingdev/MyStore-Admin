package com.store.web;

import com.store.domain.Category;
import com.store.domain.Goods;
import com.store.service.ICategoryService;
import com.store.service.IGoodsService;
import com.store.service.ServiceFactory;
import com.store.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {

    /**
     * 获取所有商品Servlet
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String getAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        List<Goods> allGoods = null;
        try {
            allGoods = goodsService.getAllGoods();
            //对集合进行反转
            Collections.reverse(allGoods);
            request.setAttribute("allGoods", allGoods);
            return "/admin/"+"main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据ID删除某一个商品Servlet
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        try {
            goodsService.deleteGoods(id);
            return "GoodsServlet?action=getAllGoods";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新某一个商品Servlet
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        goods.setImage("goods_001.png");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        try {
            goodsService.updateGoods(goods);
            return "GoodsServlet?action=getAllGoods";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加商品Servlet
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        goods.setImage("goods_001.png");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        try {
            goodsService.addGoods(goods);
            return "GoodsServlet?action=getAllGoods";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加商品的UIServlet
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String addGoodsUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        List<Category> categories = null;
        try {
            categories = categoryService.findCategory();
            request.setAttribute("allCategory", categories);
            return "/admin/"+"add.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新商品UIServlet
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateGoodsUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.setAttribute("allCategory",categories);
            return "/admin/"+"edit.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
