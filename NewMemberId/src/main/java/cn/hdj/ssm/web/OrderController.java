package cn.hdj.ssm.web;

import cn.hdj.ssm.domain.Orders;
import cn.hdj.ssm.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ids;
    //查询全部订单---未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList", ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @RequestMapping("/findOrdersAll.do")
    public ModelAndView findOrdersAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList=ids.findOrdersAll(page,size);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    //Json 穿数据
    @ResponseBody
    @RequestMapping("/findOdersJson.do")
    public  PageInfo findOrdersAll2(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
    List<Orders> ordersList=ids.findOrdersAll(page,size);
    PageInfo pageInfo=new PageInfo(ordersList);//pageInfo  不可以转成 Json数据
    return  pageInfo;
    }
}
