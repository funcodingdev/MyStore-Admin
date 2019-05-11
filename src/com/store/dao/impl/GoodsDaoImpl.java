package com.store.dao.impl;

import com.store.dao.IGoodsDao;
import com.store.domain.Goods;
import com.store.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements IGoodsDao {

    @Override
    public List<Goods> getAllGoods() throws SQLException {
        List<Goods> goodsList = null;
        String sql = "select * from goods";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        goodsList = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
        return goodsList;
    }

    @Override
    public int deleteGoods(String id) throws SQLException {
        String sql = "delete from goods where id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.update(sql, id);
    }

    @Override
    public int addGoods(Goods goods) throws SQLException {
        String sql = "insert into goods(id,name,price,image,gdesc,is_hot,cid) values(?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.update(sql, goods.getId(), goods.getName(), goods.getPrice(), goods.getImage(), goods.getGdesc(), goods.getIs_hot(), goods.getCid());
    }

    @Override
    public int updateGoods(Goods goods) throws SQLException {
        String sql = "update goods set name = ?,price = ?,image = ?,gdesc = ?,is_hot = ?,cid = ? where id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        return qr.update(sql, goods.getName(), goods.getPrice(), goods.getImage(), goods.getGdesc(), goods.getIs_hot(), goods.getCid(), goods.getId());
    }

    @Override
    public Goods getGoodsWith(String id) throws SQLException {
        String sql = "select * from goods where id = ?";
        QueryRunner qr = new QueryRunner(JDBCUtil.getDs());
        Goods goods = qr.query(sql, new BeanHandler<Goods>(Goods.class), id);
        return goods;
    }
}
