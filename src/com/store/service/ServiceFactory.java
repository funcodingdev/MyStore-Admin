package com.store.service;

import com.store.service.impl.AdminServiceImpl;
import com.store.service.impl.CateServiceImpl;
import com.store.service.impl.GoodsServiceImpl;

public class ServiceFactory {
    public static IAdminService getAdminService(){
        return new AdminServiceImpl();
    }

    public static IGoodsService getGoodsService(){
        return new GoodsServiceImpl();
    }

    public static ICategoryService getCategoryService(){
        return new CateServiceImpl();
    }
}
