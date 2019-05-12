package com.store.service.impl;

import com.store.dao.DaoFactory;
import com.store.dao.ICategoryDao;
import com.store.domain.Category;
import com.store.service.ICategoryService;

import java.sql.SQLException;
import java.util.List;

public class CateServiceImpl implements ICategoryService {

    @Override
    public List<Category> getAllCategory() throws SQLException {
        ICategoryDao categoryDao = DaoFactory.getCategoryDao();
        return categoryDao.getAllCategory();
    }

    @Override
    public Category getCategoryWithId(String id) throws SQLException {
        ICategoryDao categoryDao = DaoFactory.getCategoryDao();
        return categoryDao.getCategoryWithId(id);
    }

    @Override
    public int updateCategory(Category category) throws SQLException {
        ICategoryDao categoryDao = DaoFactory.getCategoryDao();
        return categoryDao.updateCategory(category);
    }

    @Override
    public int addCategory(String cname) throws SQLException {
        ICategoryDao categoryDao = DaoFactory.getCategoryDao();
        return categoryDao.addCategory(cname);
    }

    @Override
    public int deleteCategory(String cid) throws SQLException {
        ICategoryDao categoryDao = DaoFactory.getCategoryDao();
        return categoryDao.deleteCategory(cid);
    }

}
