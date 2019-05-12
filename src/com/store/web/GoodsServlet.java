package com.store.web;

import com.store.domain.Category;
import com.store.domain.Goods;
import com.store.domain.PageBean;
import com.store.service.ICategoryService;
import com.store.service.IGoodsService;
import com.store.service.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.omg.CORBA.INTERNAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            return DISPATCHER+":"+"/admin/" + "main.jsp";
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
            goods.setImage("goods_001.png");
            IGoodsService goodsService = ServiceFactory.getGoodsService();
            goodsService.addGoods(goods);
            //获取总页数
            HttpSession session = request.getSession();
            String currentPage = (String) session.getAttribute("currentPage");
            PageBean pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
            return DISPATCHER+":"+"GoodsServlet?action=getPageData&currentPage="+pageBean.getTotalPage();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加商品的UIServlet
     *
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
            categories = categoryService.getAllCategory();
            request.setAttribute("allCategory", categories);
            return DISPATCHER+":"+"/admin/" + "goods_add.jsp";
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
            HttpSession session = request.getSession();
            Integer currentPage = Integer.parseInt((String) session.getAttribute("currentPage"));
            PageBean pageBean = goodsService.getPageBean(currentPage);
            Integer totalPage = pageBean.getTotalPage();
            int indexPage = totalPage;
            if(currentPage<totalPage){
                indexPage = currentPage;
            }
            return DISPATCHER+":"+"GoodsServlet?action=getPageData&currentPage="+indexPage;
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
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute("currentPage");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
            goods.setImage("goods_001.png");
            IGoodsService goodsService = ServiceFactory.getGoodsService();
            goodsService.updateGoods(goods);
            return DISPATCHER+":"+"GoodsServlet?action=getPageData&currentPage="+currentPage;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新商品UIServlet
     *
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
            request.setAttribute("goods", goods);
            //获取所有分类处理
            ICategoryService categoryService = ServiceFactory.getCategoryService();
            List<Category> categories = null;
            categories = categoryService.getAllCategory();
            request.setAttribute("allCategory", categories);
            return DISPATCHER+":"+"/admin/" + "goods_edit.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前页的数据
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String getPageData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        PageBean pageBean = null;
        try {
            pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
            HttpSession session = request.getSession();
            session.setAttribute("currentPage",currentPage);
            request.setAttribute("pageBean",pageBean);
            return DISPATCHER+":"+"/admin/" + "main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模糊查询
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String getPageBeanByLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vagueField = request.getParameter("vagueField");
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute("currentPage");
        //        System.out.println("vagueField:"+vagueField+",currentPage:"+currentPage);
        if("".equals(vagueField)){//查询的数据为空
            return DISPATCHER+":"+"GoodsServlet?action=getPageData&currentPage="+currentPage;
        }
        IGoodsService goodsService = ServiceFactory.getGoodsService();
        try {
            PageBean pageBean = goodsService.getPageBeanByLike(vagueField,Integer.parseInt(currentPage));
            request.setAttribute("vagueField",vagueField);
            request.setAttribute("pageBean",pageBean);
            return DISPATCHER+":"+"/admin/" + "main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
