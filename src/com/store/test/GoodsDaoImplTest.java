package com.store.test;

import com.store.dao.DaoFactory;
import com.store.domain.Goods;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImplTest {

    @Test
    public void getAllGoods() {
        try {
            List<Goods> allGoods = DaoFactory.getGoodsDao().getAllGoods();
            System.out.println(allGoods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteGoods() {
        try {
            int i = DaoFactory.getGoodsDao().deleteGoods("1");
            System.out.println(""+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addGoods() {
        Goods goods = new Goods(1, "'梵希蔓短袖衬衣女2018新款夏季气质韩版通勤'", 159.00, "goods_001.png");
        try {
            DaoFactory.getGoodsDao().addGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateGoods() {
        Goods goods = new Goods(1, "'梵希蔓短袖衬衣女2018新款夏季气质韩版通勤'", 259.00, "goods_001.png");
        try {
            DaoFactory.getGoodsDao().updateGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGoodsCount(){
        try {
            Long goodsCount = DaoFactory.getGoodsDao().getGoodsCount();
            System.out.println(goodsCount.intValue());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGoodsCountByLike() {
        try {
            Long go = DaoFactory.getGoodsDao().getGoodsCountByLike("梵");
            System.out.println(go.intValue());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPageDataByLike() {
        try {
            List<Goods> list = DaoFactory.getGoodsDao().getGoodsByLike("梵");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}