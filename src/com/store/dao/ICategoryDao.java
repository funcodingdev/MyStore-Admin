package com.store.dao;

import com.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
    List<Category> findCategory() throws SQLException;
}
