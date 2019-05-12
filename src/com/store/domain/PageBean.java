package com.store.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
    private Integer currentPage;
    private Integer totalPage;
    private Integer totalCount;
    private Integer pageCount = 5;//每页的数量
    private List<Goods> goodsList = new ArrayList<>();
    private Integer isGeneral = 1;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getIsGeneral() {
        return isGeneral;
    }

    public void setIsGeneral(Integer isGeneral) {
        this.isGeneral = isGeneral;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", goodsList=" + goodsList +
                '}';
    }
}
