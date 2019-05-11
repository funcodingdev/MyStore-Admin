package com.store.dao.impl;

import com.store.dao.IAdminDao;
import com.store.domain.Admin;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDaoImpl implements IAdminDao {

    @Override
    public Admin checkAdmin(String username, String password) throws SQLException {
        String sql = "select * from admin where username = ? and password = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        Admin admin = null;
        admin = qr.query(sql,new BeanHandler<Admin>(Admin.class),username,password);
        return admin;
    }
}
