package com.store.dao;

import com.store.domain.Goods;
import com.store.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsDao {
    //得到所有的商品
    List<Goods> getAllGoods() throws SQLException;
    //根据ID删除某一种商品
    int deleteGoods(String id) throws SQLException;
    //添加商品到数据库中
    int addGoods(Goods goods) throws SQLException;
    //传入一个商品，修改它
    int updateGoods(Goods goods) throws SQLException;
    //得到一个商品
    Goods getGoodsWith(String id) throws SQLException;

    Long getGoodsCount() throws SQLException;

    List<Goods> getPageData(Integer currentPageIndex, Integer pageCount) throws SQLException;

    List<Goods> getGoodsByLike(String vagueField) throws SQLException;

    Long getGoodsCountByLike(String vagueField) throws SQLException;
}
