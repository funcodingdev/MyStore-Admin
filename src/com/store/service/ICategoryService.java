package com.store.service;

import com.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> findCategory() throws SQLException;
}
