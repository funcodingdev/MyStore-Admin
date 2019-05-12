package com.store.service;

import com.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory() throws SQLException;

    Category getCategoryWithId(String id) throws SQLException;

    int updateCategory(Category category) throws SQLException;

    int addCategory(String cname) throws SQLException;

    int deleteCategory(String cid) throws SQLException;
}
