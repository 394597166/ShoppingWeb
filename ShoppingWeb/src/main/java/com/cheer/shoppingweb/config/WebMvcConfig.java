package com.cheer.shoppingweb.config;

import com.cheer.shoppingweb.component.WebHandlerInterceptor;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
    public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private WebHandlerInterceptor webHandlerInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //转发网页
        registry.addViewController("/register.html").setViewName("user/register.html");
        registry.addViewController("/retrievePassword.html").setViewName("user/retrievePassword.html");
        registry.addViewController("/login.html").setViewName("user/login.html");
        registry.addViewController("/updatePassword.html").setViewName("user/updatePassword.html");
        registry.addViewController("/updateMail.html").setViewName("user/updateMail.html");
        registry.addViewController("/personalCenter.html").setViewName("user/personalCenter.html");
        registry.addViewController("/address.html").setViewName("user/address.html");
        registry.addViewController("/balance.html").setViewName("user/balance.html");
        registry.addViewController("/service.html").setViewName("other/service.html");
        registry.addViewController("/onlinePayment.html").setViewName("other/onlinePayment.html");
        registry.addViewController("/distribution.html").setViewName("other/distribution.html");
        registry.addViewController("/FAQ.html").setViewName("other/FAQ.html");
        registry.addViewController("/shoppingProcess.html").setViewName("other/shoppingProcess.html");
        registry.addViewController("/exchanged.html").setViewName("other/exchanged.html");
        registry.addViewController("/exchanged2.html").setViewName("other/exchanged2.html");
        registry.addViewController("/about.html").setViewName("other/about.html");
        registry.addViewController("/index.html").setViewName("/index.html");
        registry.addViewController("/adminlogin.html").setViewName("admin/adminlogin.html");
        registry.addViewController("/adminCoupon.html").setViewName("admin/adminCoupon.html");
        registry.addViewController("/userCoupon.html").setViewName("user/userCoupon.html");
        registry.addViewController("/receiveCoupon.html").setViewName("user/receiveCoupon.html");
        registry.addViewController("/goods.html").setViewName("goods/goods.html");
        registry.addViewController("/goodsPaging.html").setViewName("goods/goodsPaging.html");
        registry.addViewController("/adminGoods.html").setViewName("admin/adminGoods.html");
        registry.addViewController("/usergoodscollect.html").setViewName("user/usergoodscollect.html");
        registry.addViewController("/cart.html").setViewName("cart/cart.html");
        registry.addViewController("/confirmOrder.html").setViewName("order/confirmOrder.html");
        registry.addViewController("/userPay.html").setViewName("order/userPay.html");
        registry.addViewController("/userPay.html").setViewName("order/order.html");
        registry.addViewController("/adminOrder.html").setViewName("admin/adminOrder.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/register.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/retrievePassword.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/login.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/updatePassword.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/updateMail.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/personalCenter.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/address.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/balance.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/service.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/onlinePayment.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/distribution.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/FAQ.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/shoppingProcess.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/exchanged.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/exchanged2.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/about.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/index.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/adminlogin.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/adminCoupon.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/userCoupon.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/receiveCoupon.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/goods.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/goodsPaging.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/adminGoods.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/usergoodscollect.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/cart.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/confirmOrder.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/userPay.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/order.html");
        registry.addInterceptor(webHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/adminOrder.html");
    }
}
