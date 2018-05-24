package com.yanglq.service.impl;

import com.yanglq.entity.Book;
import com.yanglq.service.IBookService;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceImpl implements IBookService {

	@KContainer
	KieContainer kieContainer;
	@KSession("bookprice_ksession")
	KieSession kieSession;
	/**
	 * 获取一本书的当前实际售价
	 *
	 * @param
	 * @return
	 */
	public double getBookSalePrice(Book b) {
		if (b == null) {
			throw new NullPointerException("Book can not be null.");
		}
		Collection<String> kieBaseNames = kieContainer.getKieBaseNames();
		for (String s:kieBaseNames ) {
			System.out.print(s);
		}
		kieSession.insert(b);
		kieSession.fireAllRules();
		return b.getSalesPrice();
	}

}
