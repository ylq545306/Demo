package com.yanglq.web;

import com.yanglq.entity.Golfer;
import com.yanglq.service.IGolfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/golf")
public class GolfController {

    @Autowired
    private IGolfService iGolfService;

    /**
     * 获取人员位置
     *
     * @return
     */
    @RequestMapping(value = "/getpo.do")
    @ResponseBody
    public void orderOneBook(HttpServletRequest request) {
        String[] names = new String[]{"Fred", "Joe", "Bob", "Tom"};
        String[] colors = new String[]{"red", "blue", "plaid", "orange"};
        int[] positions = new int[]{1, 2, 3, 4};
        List<Golfer> golfers = new ArrayList<Golfer>();
        for (int n = 0; n < names.length; n++) {
            for (int c = 0; c < colors.length; c++) {
                for (int p = 0; p < positions.length; p++) {
                    golfers.add(new Golfer(names[n], colors[c],
                            positions[p]));
                }
            }
        }
        iGolfService.getGolf(golfers);
//        double realPrice = iBookService.getBookSalePrice(b);
//        request.setAttribute("book", b);
//        System.out.println(b.getName() + ":" + realPrice);

//        return b;
    }
}
