package com.store.dao.impl;

import com.store.dao.ICategoryDao;
import com.store.domain.Category;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {

    @Override
    public List<Category> findCategory() throws SQLException {
        String sql = "select * from category";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        List<Category> categories = qr.query(sql, new BeanListHandler<Category>(Category.class));
        return categories;
    }
}
