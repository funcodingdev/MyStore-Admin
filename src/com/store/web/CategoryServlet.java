package com.store.web;

import com.store.domain.Category;
import com.store.service.ICategoryService;
import com.store.service.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {

    /**
     * 查找所有的分类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String getAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        try {
            List<Category> categories = categoryService.getAllCategory();
            request.setAttribute("allCategory",categories);
            return DISPATCHER+":"+"/admin/"+"category.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *更新分类UI
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateCategoryUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        try {
           Category category = categoryService.getCategoryWithId(id);
            request.setAttribute("category",category);
            return DISPATCHER+":"+"/admin/"+"category_edit.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新分类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Category category = new Category();
        try {
            BeanUtils.populate(category,parameterMap);
            ICategoryService categoryService = ServiceFactory.getCategoryService();
            categoryService.updateCategory(category);
            return DISPATCHER+":"+"CategoryServlet?action=getAllCategory";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        try {
            categoryService.deleteCategory(id);
            return DISPATCHER+":"+"CategoryServlet?action=getAllCategory";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        System.out.println(cname);
        ICategoryService categoryService = ServiceFactory.getCategoryService();
        try {
            categoryService.addCategory(cname);
            return DISPATCHER+":"+"CategoryServlet?action=getAllCategory";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
