package com.yanglq.service.impl;

import com.yanglq.entity.Golfer;
import com.yanglq.service.IGolfService;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GolfServiceImpl implements IGolfService {

    @KContainer
    KieContainer kieContainer;
    @KSession("golf_ksession")
    KieSession kieSession;

    /**
     * 获取个人站位
     *
     * @param
     * @param gs
     * @return
     */
    @Override
    public void getGolf(List<Golfer> gs) {
        if (gs == null) {
            throw new NullPointerException("Golfer can not be null.");
        }
        Collection<String> kieBaseNames = kieContainer.getKieBaseNames();
        for (String s : kieBaseNames) {
            System.out.print(s);
        }
        for (Golfer g : gs
                ) {
            kieSession.insert(g);
        }
        kieSession.fireAllRules();
//        kieSession.dispose();
//        return g.getPosition();
    }


}
