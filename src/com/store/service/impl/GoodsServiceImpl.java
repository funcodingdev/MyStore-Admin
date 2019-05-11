package com.store.service.impl;

import com.store.dao.DaoFactory;
import com.store.dao.IGoodsDao;
import com.store.domain.Goods;
import com.store.service.IGoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    @Override
    public List<Goods> getAllGoods() throws SQLException {
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        return goodsDao.getAllGoods();
    }

    @Override
    public int deleteGoods(String id) throws SQLException {
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        return goodsDao.deleteGoods(id);
    }

    @Override
    public int addGoods(Goods goods) throws SQLException {
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        return goodsDao.addGoods(goods);
    }

    @Override
    public Goods getGoodsWith(String id) throws SQLException {
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        return goodsDao.getGoodsWith(id);
    }

    @Override
    public int updateGoods(Goods goods) throws SQLException {
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        return goodsDao.updateGoods(goods);
    }
}
