package com.store.dao.impl;

import com.store.dao.ICategoryDao;
import com.store.domain.Category;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {

    @Override
    public List<Category> getAllCategory() throws SQLException {
        String sql = "select * from category";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        List<Category> categories = qr.query(sql, new BeanListHandler<Category>(Category.class));
        return categories;
    }

    @Override
    public Category getCategoryWithId(String id) throws SQLException {
        String sql = "select * from category where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.query(sql,new BeanHandler<Category>(Category.class),id);
    }

    @Override
    public int updateCategory(Category category) throws SQLException {
        String sql = "update category set cname = ? where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.update(sql,category.getCname(),category.getCid());
    }

    @Override
    public int addCategory(String cname) throws SQLException {
        String sql = "insert into category(cname) values(?)";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.update(sql,cname);
    }

    @Override
    public int deleteCategory(String cid) throws SQLException {
        String sql = "delete from category where cid = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.update(sql,cid);
    }

}
