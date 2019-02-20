package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebadmin.model.Admin;
import com.cheer.shoppingwebadmin.service.AdminService;
import com.cheer.shoppingwebcategory.model.Category;
import com.cheer.shoppingwebcategory.model.Subclassification;
import com.cheer.shoppingwebcategory.model.Subseries;
import com.cheer.shoppingwebcategory.service.CategoryService;
import com.cheer.shoppingwebcategory.service.SubclassificationService;
import com.cheer.shoppingwebcategory.service.SubseriesService;
import com.cheer.shoppingwebcoupon.service.CouponService;
import com.cheer.shoppingwebexpress.model.Express;
import com.cheer.shoppingwebexpress.service.ExpressService;
import com.cheer.shoppingwebexpress.service.UserOrderExpressService;
import com.cheer.shoppingwebgoods.model.Goods;
import com.cheer.shoppingwebgoods.service.GoodsService;
import com.cheer.shoppingwebgoods.service.InventoryService;
import com.cheer.shoppingweborder.model.Userorder;
import com.cheer.shoppingweborder.service.UserorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubclassificationService subclassificationService;
    @Autowired
    private SubseriesService subseriesService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private UserorderService userorderService;
    @Autowired
    private ExpressService expressService;
    @Autowired
    private UserOrderExpressService userOrderExpressService;
    @Autowired
    private UtilService utilService;
    /**
     * 打开登录页面
     * @return
     */
    @RequestMapping(value = "/adminlogin.html")
    public String adminlogin(){
        return "adminlogin";
    }

    /**
     * 打开优惠卷管理页面
     * @return
     */
    @RequestMapping(value = "/adminCoupon.html")
    public String adminCoupon(){
        return "adminCoupon";
    }

    /**
     * 打开商品管理页面
     * @return
     */
    @RequestMapping(value = "/adminGoods.html")
    public String adminGoods(){
        return "adminGoods";
    }

    /**
     * 打开订单管理页面
     * @return
     */
    @RequestMapping(value = "/adminOrder.html")
    public String adminOrder(){
        return "adminOrder";
    }

    /**
     * 登录账号和密码
     * @param adminName
     * @param adminPassword
     * @return
     */
    @RequestMapping(value = "/adminLogin")
    @ResponseBody
    public Map<String,Object> adminLogin(@RequestParam(value = "adminName") String adminName,@RequestParam(value = "adminPassword") String adminPassword, HttpSession session){
        Admin admin = this.adminService.checkAdmin(adminName,adminPassword);
        Map<String,Object> map = new HashMap<>();
        if (null != admin){
            session.setAttribute("adminName",admin.getAdminName());
            map.put("result",true);
            map.put("data","登录成功！");
        }else{
            map.put("result",false);
            map.put("data","用户名密码不匹配！");
        }
        return map;
    }

    /**
     * 添加优惠卷
     * @param couponFull
     * @param couponSubtract
     * @param session
     * @return
     */
    @RequestMapping(value = "/insertCoupon")
    @ResponseBody
    public Map<String,Object> insertCoupon( @RequestParam(value = "couponFull") Integer couponFull, @RequestParam(value = "couponSubtract") Integer couponSubtract, @RequestParam(value = "data")  Integer data, HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            Integer couponId = this.utilService.UUID();
            //获得当前时间
            Calendar c = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
            String couponStart = dateFormat.format(c.getTime());
            c.add(Calendar.DAY_OF_MONTH,data);
            String couponFinish = dateFormat.format(c.getTime());
            this.couponService.insertCoupon(couponId,couponFull,couponSubtract,couponStart,couponFinish);
            map.put("data","添加成功！");
        }
        return map;
    }

    /**
     * 获得所有的商品信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectAllGoods")
    @ResponseBody
    public Map<String,Object> selectAllGoods(HttpSession session,@RequestParam(value = "goodsState") String goodsState){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            if (goodsState.equals("上架")){
                List<Goods> goodsList = this.goodsService.selectAllGoods("上架");
                map.put("goodsList",goodsList);
            }else if(goodsState.equals("下架")){
                List<Goods> goodsList = this.goodsService.selectAllGoods("下架");
                map.put("goodsList",goodsList);
            }else{
                List<Goods> goodsList = this.goodsService.selectAllGoods(null);
                map.put("goodsList",goodsList);
            }
        }
        return map;
    }

    /**
     * 按照商品名搜索商品
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectAllGoodsLikeName")
    @ResponseBody
    public Map<String,Object> selectAllGoodsLikeName(HttpSession session,@RequestParam(value = "goodsState") String goodsState){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            String goodsName = "%"+goodsState+"%";
            List<Goods> goodsList = this.goodsService.selectAllGoodsLikeName(goodsName);
            map.put("goodsList",goodsList);
        }
        return map;
    }

    /**
     * 更改商品状态（上架、下架）
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateGoodsState")
    @ResponseBody
    public Map<String,Object> updateGoodsState(@RequestParam(value = "goodsId") Integer goodsId,@RequestParam(value = "goodsState") String goodsState,HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            this.goodsService.updateGoods(goodsId,goodsState);
            map.put("data","更改成功！");
        }
        return map;
    }

    /**
     * 获得分类清单
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectALLcategory")
    @ResponseBody
    public Map<String,Object> selectALLcategory(HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            List<Category> categoryList = this.categoryService.CategoryAll();
            map.put("categoryList",categoryList);
        }
        return map;
    }

    /**
     * 获得子类清单
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectSubclassificationAndCategoryId")
    @ResponseBody
    public Map<String,Object> selectSubclassificationAndCategoryId(@RequestParam(value = "categoryId")Integer categoryId,HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            List<Subclassification> subclassificationList = this.subclassificationService.selectSubclassificationAndcategoryId(categoryId);
            map.put("subclassificationList",subclassificationList);
        }
        return map;
    }

    /**
     * 获得次类清单
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectSubseriesAndSubclassificationId")
    @ResponseBody
    public Map<String,Object> selectSubseriesAndSubclassificationId(@RequestParam(value = "subclassificationId")Integer subclassificationId,HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            List<Subseries> subseriesList = this.subseriesService.selectSubseriesAndSubclassificationId(subclassificationId);
            map.put("subseriesList",subseriesList);
        }
        return map;
    }

    /**
     * 新增商品
     * @param session
     * @return
     */
    @RequestMapping(value = "/insertGoods")
    @ResponseBody
    public Map<String,Object> insertGoods(@RequestParam(value = "goodsName")String goodsName,@RequestParam(value = "goodsSpecification")String goodsSpecification,@RequestParam(value = "goodsDescribe")String goodsDescribe,@RequestParam(value = "goodsPrice")Double goodsPrice,@RequestParam(value = "goodsVipPrice")Double goodsVipPrice,@RequestParam(value = "categoryId")Integer categoryId,@RequestParam(value = "subclassificationId")Integer subclassificationId,@RequestParam(value = "subseriesId")Integer subseriesId,@RequestParam(value = "inventoryName")String inventoryName,HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            Integer goodsId = this.utilService.UUID();
            String goodsState = "上架";
            this.goodsService.insertGoods(goodsId,goodsName,goodsSpecification,goodsDescribe,goodsPrice,goodsVipPrice,categoryId,subclassificationId,subseriesId,goodsState);
            String[] arr = inventoryName.split(",");
            for (String a:arr
            ) {
                Integer inventoryId = this.utilService.UUID();
                this.inventoryService.insertInventory(inventoryId,a,goodsId);
            }
            map.put("data","新建商品成功！");
        }
        return map;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping(value = "/adminLogout")
    public String adminLogout(HttpSession session){
        session.invalidate();
        return "redirect:http://localhost:8080/index.html";
    }

    /**
     * 获得所有订单
     */
    @RequestMapping(value = "/selectAlladminorder")
    @ResponseBody
    public Map<String,Object> selectAlladminorder(HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            //所有订单
            List<Userorder> userorderList = this.userorderService.selectAllUserorder();
            //待发货
            List<Userorder> userorderListSendgoods = this.userorderService.selectAllUserorderAndState("待发货");
            map.put("userorderList",userorderList);
            map.put("userorderListSendgoods",userorderListSendgoods);
        }
        return map;
    }

    /**
     * 搜索单个订单
     */
    @RequestMapping(value = "/selectOrderOne")
    @ResponseBody
    public Map<String,Object> selectOrderOne(@RequestParam(value = "userorderId")Integer userorderId, HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            //所有订单
            Userorder userorder = this.userorderService.selectUserorderAnduserorderId(userorderId);
            List<Userorder> userorderList = new ArrayList<>();
            userorderList.add(userorder);
            map.put("userorderList",userorderList);
        }
        return map;
    }

    /**
     * 获得所有快递公司
     */
    @RequestMapping(value = "/selectExpressAll")
    @ResponseBody
    public Map<String,Object> selectExpressAll(HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            //所有快递公司
            List<Express> expressList = this.expressService.selectExpressAll();
            map.put("expressList",expressList);
        }
        return map;
    }

    /**
     * 获得所有快递公司
     */
    @RequestMapping(value = "/insertExpress")
    @ResponseBody
    public Map<String,Object> insertExpress(@RequestParam(value = "userorderexpressName")String userorderexpressName,@RequestParam(value = "userorderId")Integer userorderId,@RequestParam(value = "expressId")Integer expressId, HttpSession session){
        String adminName = (String) session.getAttribute("adminName");
        Map<String,Object> map = utilService.checkAdminName(adminName);
        Boolean flog = (Boolean) map.get("result");
        if (flog){
            Integer userorderexpressId = this.utilService.UUID();
            this.userOrderExpressService.insertUserOrderExpress(userorderexpressId,userorderexpressName,userorderId,expressId);
            this.userorderService.updateUserorder(userorderId,"待收货");
        }
        return map;
    }
}
