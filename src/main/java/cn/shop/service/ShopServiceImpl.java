package cn.shop.service;

import cn.shop.dao.ShopMapper;
import cn.shop.pojo.Goods_detail;
import cn.shop.pojo.Goods_sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Override
    public List<Goods_detail> getShopList(Integer sortid, Integer CurrentNo, Integer PageSize) {
        return shopMapper.getShopList(sortid,CurrentNo,PageSize);
    }


    @Override
    public int getShopListCount(Integer sortid) {
        return shopMapper.getShopListCount(sortid);
    }

    @Override
    public Goods_detail getGoods_dateil(Integer sortid) {
        return shopMapper.getGoods_dateil(sortid);
    }

    @Override
    public List<Goods_sort> getGoods_sortList() {
        return shopMapper.getGoods_sortList();
    }

    @Override
    public Integer updateGoods(Integer remaining, Integer id) {
        return shopMapper.updateGoods(remaining,id);
    }
}
