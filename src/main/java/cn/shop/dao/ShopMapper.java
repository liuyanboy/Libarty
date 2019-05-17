package cn.shop.dao;

import cn.shop.pojo.Goods_detail;
import cn.shop.pojo.Goods_sort;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
    List<Goods_detail> getShopList(@Param("sortid") Integer sortid, @Param("CurrentNo") Integer CurrentNo,@Param("PageSize") Integer PageSize);

    Integer updateGoods(@Param("remaining")Integer remaining , @Param("id")Integer id);

    int getShopListCount(@Param("sortid")Integer sortid);

    Goods_detail getGoods_dateil(@Param("id")Integer id);

    List<Goods_sort> getGoods_sortList();
}
