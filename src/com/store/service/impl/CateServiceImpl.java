package com.store.service.impl;

import com.store.dao.DaoFactory;
import com.store.dao.ICategoryDao;
import com.store.domain.Category;
import com.store.service.ICategoryService;

import java.sql.SQLException;
import java.util.List;

public class CateServiceImpl implements ICategoryService {

    @Override
    public List<Category> findCategory() throws SQLException {
        ICategoryDao categoryDao = DaoFactory.getCategoryDao();
        return categoryDao.findCategory();
    }
}
