package com.yanglq.web;

import com.yanglq.config.ReloadDroolsRules;
import com.yanglq.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IHelloService iHelloService;
    @Autowired
    private ReloadDroolsRules rules;

    @RequestMapping("/test.do")
    @ResponseBody
    public void hello() {
        System.out.println(iHelloService.hello());
    }

    @ResponseBody
    @RequestMapping("/address.do")
    public void test() {
        int ruleFiredCount = iHelloService.testDT();
        System.out.println("触发了" + ruleFiredCount + "条规则");

//        if (result.isPostCodeResult()) {
//            System.out.println("规则校验通过");
//        }
    }

    @ResponseBody
    @RequestMapping("/reload.do")
    public String reload() throws IOException {
        rules.reload();
        return "ok";
    }


    /* 重新加载配置文件(只有想不到没有猜不到)
    * @Author        张志朋
    * @param request  void
    * @Date        2016年8月24日
    * 更新日志
    * 2016年8月24日 张志朋  首次创建
    *
            */
    @RequestMapping("/refreshXmlWebApplicationContext.do")
    @ResponseBody
    public void refresh(HttpServletRequest request) {
        XmlWebApplicationContext context =
                (XmlWebApplicationContext) WebApplicationContextUtils
                        .getWebApplicationContext(request.getServletContext());
        context.refresh();
    }
}
