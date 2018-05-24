package com.yanglq.web;

import com.yanglq.entity.User;
import com.yanglq.service.IDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    private IDrinkService iDrinkService;

    /**
     * 喝汽水
     *
     * @return
     */
    @RequestMapping(value = "/calc.do")
    @ResponseBody
    public Object orderOneBook(HttpServletRequest request) {
        // 初始化用户实例
        User user = new User();
        user.setMoney(6);// 设置钱数

        double realPrice = iDrinkService.getDrinkNum(user);
        request.setAttribute("book", user);
        System.out.println("小明还剩钱数：" + user.getMoney());
        System.out.println("计算完毕");
        return user;
    }
}
