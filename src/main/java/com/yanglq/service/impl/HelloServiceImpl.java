package com.yanglq.service.impl;

import com.skywin.drools.dongtai.model.Address;
import com.skywin.drools.dongtai.model.fact.AddressCheckResult;
import com.skywin.drools.dongtai.util.KieUtils;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.yanglq.service.IHelloService;

import java.util.Collection;

@Service
public class HelloServiceImpl implements IHelloService {

    @KContainer
    KieContainer kieContainer;
    @KSession("drink_ksession")
    KieSession kieSession;


    @Override
    public String hello() {
        // TODO Auto-generated method stub
        return "Hello";
    }

    @Override
    public int testDT() {
        KieSession ks = KieUtils.getKieSession();

        if (ks == null) {
            ks = kieSession;
        }
        Collection<String> kieBaseNames = kieContainer.getKieBaseNames();
        for (String s : kieBaseNames) {
            System.out.print(s);
        }

        Address address = new Address();
        address.setPostcode("994251");

        AddressCheckResult result = new AddressCheckResult();
        ks.insert(address);
        ks.insert(result);
        return ks.fireAllRules();
    }

}
