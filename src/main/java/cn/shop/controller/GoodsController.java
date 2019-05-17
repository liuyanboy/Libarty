package cn.shop.controller;

import cn.shop.dao.ShopMapper;
import cn.shop.pojo.Goods_detail;
import cn.shop.pojo.Goods_sort;
import cn.shop.pojo.Page;
import cn.shop.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/Goods")
public class GoodsController {

    @Resource
    private ShopService shopService;

    @RequestMapping("/list")
    public String getGoodsList(@RequestParam(required = false) Integer sortId, @RequestParam(required = false)Integer currPageNo, Model model){
        if(currPageNo == null){
            currPageNo = 1 ;
        }
        Page page = new Page();
        Integer TotalCount = shopService.getShopListCount(sortId);
        page.setPageCount(TotalCount);
        page.setCurrentNo(currPageNo);
        List<Goods_detail> goodsDtailList =shopService.getShopList(sortId,(page.getCurrentNo() - 1) * page.getPageSize() , page.getPageSize() );
        List<Goods_sort> goodsSortsList = shopService.getGoods_sortList();
        model.addAttribute("page",page);
        model.addAttribute("sortIds",sortId);
        model.addAttribute("goodsDtailList",goodsDtailList);
        model.addAttribute("goodsSortsList",goodsSortsList);
        return "goodsList";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(@RequestParam(required = false)Integer id,Model model){
        Goods_detail detail = shopService.getGoods_dateil(id);
        model.addAttribute("detail",detail);
        return "goodsUpdate";
    }

    @RequestMapping("/updateGoods")
    public String updateGoods(@RequestParam(required = false) Integer id, @RequestParam(required = false)Integer remaining){
        Integer count = shopService.updateGoods(remaining,id);
        if (count > 0) {
            return "redirect:/Goods/list";  //修改成功
        } else {
            return "redirect:/Goods/toUpdatePage?id=" + id;
        }
    }
}
