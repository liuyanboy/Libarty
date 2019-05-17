package cn.shop.service;

import cn.shop.pojo.Goods_detail;
import cn.shop.pojo.Goods_sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopService {
    List<Goods_detail> getShopList(Integer sortid, Integer CurrentNo, Integer PageSize);


    int getShopListCount(Integer sortid);

    Goods_detail getGoods_dateil(Integer sortid);

    List<Goods_sort> getGoods_sortList();


    Integer updateGoods(Integer remaining ,Integer id);
}
