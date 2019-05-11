package com.store.service;

import com.store.domain.Goods;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsService {
    List<Goods> getAllGoods() throws SQLException;

    int deleteGoods(String id) throws SQLException;

    int addGoods(Goods goods) throws SQLException;

    Goods getGoodsWith(String id) throws SQLException;

    int updateGoods(Goods goods) throws SQLException;
}
