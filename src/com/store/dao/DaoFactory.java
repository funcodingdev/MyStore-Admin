package com.store.dao;

import com.store.dao.impl.AdminDaoImpl;
import com.store.dao.impl.CategoryDaoImpl;
import com.store.dao.impl.GoodsDaoImpl;

public class DaoFactory {
    public static IAdminDao getAdminDao(){
        return new AdminDaoImpl();
    }
    public static IGoodsDao getGoodsDao(){
        return new GoodsDaoImpl();
    }

    public static ICategoryDao getCategoryDao(){
        return new CategoryDaoImpl();
    }
}
