package com.store.service.impl;

import com.store.dao.DaoFactory;
import com.store.dao.IGoodsDao;
import com.store.domain.Goods;
import com.store.domain.PageBean;
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

    @Override
    public PageBean getPageBean(Integer currentPage) throws SQLException {
        PageBean pageBean = new PageBean();
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        pageBean.setCurrentPage(currentPage);//设置当前页
        pageBean.setTotalCount(goodsDao.getGoodsCount().intValue());//设置商品总数量
        pageBean.setPageCount(6);//设置每页的数据
        double totalPage = Math.ceil(1.0*pageBean.getTotalCount() / pageBean.getPageCount());//总页数(Math.ceil()向上取整)
        pageBean.setTotalPage((int)totalPage);//设置总页数
        Integer currentPageIndex = (pageBean.getCurrentPage()-1)*pageBean.getPageCount();//当前页的角标
        List<Goods> goodsList = goodsDao.getPageData(currentPageIndex,pageBean.getPageCount());//设置当前页的数据
        pageBean.setGoodsList(goodsList);
        return pageBean;
    }

    @Override
    public PageBean getPageBeanByLike(String vagueField,Integer currentPage) throws SQLException {
        IGoodsDao goodsDao = DaoFactory.getGoodsDao();
        PageBean pageBean = new PageBean();
        pageBean.setIsGeneral(0);
        pageBean.setCurrentPage(1);
        pageBean.setTotalCount(goodsDao.getGoodsCountByLike(vagueField).intValue());//设置总数量
        pageBean.setPageCount(pageBean.getTotalCount());
        pageBean.setTotalPage(1);
        pageBean.setGoodsList(goodsDao.getGoodsByLike(vagueField));//设置所有的数据
        return pageBean;
    }

}
