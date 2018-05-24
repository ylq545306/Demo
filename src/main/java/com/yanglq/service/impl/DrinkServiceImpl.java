package com.yanglq.service.impl;

import com.yanglq.entity.User;
import com.yanglq.service.IDrinkService;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DrinkServiceImpl implements IDrinkService {

    @KContainer
    KieContainer kieContainer;
    @KSession("drink_ksession")
    KieSession kieSession;

    /**
     * 获取最终瓶子总数
     *
     * @param
     * @return
     */
    public double getDrinkNum(User u) {
        if (u == null) {
            throw new NullPointerException("User can not be null.");
        }
        Collection<String> kieBaseNames = kieContainer.getKieBaseNames();
        for (String s : kieBaseNames) {
            System.out.print(s);
        }
        kieSession.insert(u);
        kieSession.fireAllRules();
        return u.getTotals();
    }

}
