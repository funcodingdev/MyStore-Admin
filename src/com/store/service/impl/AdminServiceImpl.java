package com.store.service.impl;

import com.store.dao.DaoFactory;
import com.store.dao.IAdminDao;
import com.store.dao.impl.AdminDaoImpl;
import com.store.domain.Admin;
import com.store.service.IAdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements IAdminService {

    @Override
    public Admin login(String username, String password) throws Exception {
        IAdminDao adminDao = DaoFactory.getAdminDao();
        Admin admin = null;
        admin = adminDao.checkAdmin(username,password);
        if(admin != null){
            return admin;
        }else{
            throw new Exception("用户名或密码错误");
        }
    }
}
