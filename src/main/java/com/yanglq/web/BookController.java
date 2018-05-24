package com.yanglq.web;

import com.yanglq.entity.Book;
import com.yanglq.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService iBookService;

	/**
	 * 购买一本书
	 *
	 * @return
	 */
	@RequestMapping(value = "/order.do")
	@ResponseBody
	public Object orderOneBook(HttpServletRequest request) {
		Book b = new Book();
		b.setBasePrice(120.50);
		b.setClz("computer12");
		b.setName("C plus programing");
		b.setSalesArea("China");
		b.setYears(2);

		double realPrice = iBookService.getBookSalePrice(b);
		request.setAttribute("book", b);
		System.out.println(b.getName() + ":" + realPrice);

		return b;
	}
}
