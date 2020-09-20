package cn.briup.xia.controller;

import cn.briup.xia.baen.Customer;
import cn.briup.xia.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/cust/findAll")
    @ResponseBody
    public List<Customer> findAll(){
          List<Customer> list=customerService.findByAll();
          return list;
      }
    @RequestMapping("/cust/findByid")
    @ResponseBody
    public Customer findByid(@RequestParam("custId")Integer custId){
          Customer customer=customerService.findCustById(custId);
          return customer;
      }
     @RequestMapping("/cust/findByName")
     @ResponseBody
     public  Customer findByName(@RequestParam("custName")String custName){
        return customerService.findCustomerByName(custName);
     }
     //增加用户
//    @PostMapping("/cust/insert")
//     public void insetCust(Customer customer){
//        customerService.insertCustomer(customer);
//    }
    //删除
    @GetMapping("/delete/cust")
    public ModelAndView delectCust(@RequestParam("custId")Integer custId){
        ModelAndView mv=new ModelAndView();
        customerService.delectCustomerById(custId);
        mv.addObject("msg","删除成功!");
        mv.setViewName("redirect:/main.html");
        return mv;
    }
    @GetMapping("delete/custbook")
    public  ModelAndView deletebookcust(@RequestParam("bookId") Integer bookId,@RequestParam("custId")Integer custId){
        ModelAndView mv=new ModelAndView();
        Boolean bl=customerService.delectBookByCustomerId(bookId,custId);
        if(bl){
            mv.addObject("msg","取消成功");
            mv.setViewName("redirect:/main.html");
            return  mv;
        }else {
            mv.setViewName("/index");
            return mv;
        }
    }
    @GetMapping("delect/custcomic")
    public  ModelAndView deleteComicCust(@RequestParam("comicId")Integer comicId,@RequestParam("custId")Integer custId){
        ModelAndView mv=new ModelAndView();
        Boolean bl=customerService.insertComicByCustomerId(comicId,custId);
        if(bl){
            mv.addObject("msg","取消成功");
            mv.setViewName("redirect:/main.html");
            return  mv;
        }else {
            mv.setViewName("/index");
            return mv;
        }
    }
    @GetMapping("insert/custbook")
    public  ModelAndView insetBookCust(@RequestParam("bookId")Integer bookId,@RequestParam("custId")Integer custId){
        ModelAndView mv=new ModelAndView();
        Boolean bl=customerService.insetBookByCutsomerId(bookId,custId);
        if(bl){
            mv.addObject("msg","加入成功");
            mv.setViewName("redirect:/main.html");
            return  mv;
        }else {
            mv.setViewName("/index");
            return mv;
        }
    }
    @GetMapping("insert/custcomic")
    public ModelAndView insertComicCust(@RequestParam("comicId")Integer comicId,@RequestParam("custId")Integer custId){
        ModelAndView mv=new ModelAndView();
        Boolean bl=customerService.insertComicByCustomerId(comicId, custId);
        if(bl){
            mv.addObject("msg","加入成功");
            mv.setViewName("redirect:/main.html");
            return  mv;
        }else {
            mv.setViewName("/index");
            return mv;
        }
    }
}
