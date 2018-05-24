package com.skywin.drools.dongtai.controller;

import com.skywin.drools.dongtai.config.ReloadDroolsRules;
import com.skywin.drools.dongtai.model.Address;
import com.skywin.drools.dongtai.model.fact.AddressCheckResult;
import com.skywin.drools.dongtai.util.KieUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by yanglq on 2018/5/22.
 */
@RequestMapping("/test")
@Controller
public class TestController {


    @Resource
    private ReloadDroolsRules rules;

    @ResponseBody
    @RequestMapping("/address")
    public void test() {
        KieSession kieSession = KieUtils.getKieSession();

        Address address = new Address();
        address.setPostcode("994251");

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        if (result.isPostCodeResult()) {
            System.out.println("规则校验通过");
        }

    }


    @ResponseBody
    @RequestMapping("/reload")
    public String reload() throws IOException {
        rules.reload();
        return "ok";
    }
}