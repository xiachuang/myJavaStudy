package cn.hdj.ssm.web;

import cn.hdj.ssm.domain.Product;
import cn.hdj.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class productController {
    @Autowired
    private IProductService ips;

    @RequestMapping("/findByid.do")
    public ModelAndView findByid(@RequestParam(name = "id") int id) {
        ModelAndView mv = new ModelAndView();
        Product product = ips.findProductById(id);
        mv.addObject("product", product);
        mv.setViewName("index");
        return mv;

    }

    @RequestMapping("/findByName.do")
    public ModelAndView findByName(@RequestParam(name = "productName") String name) {
        ModelAndView mv = new ModelAndView();
        Product product = ips.findProductByName(name);
        mv.addObject("productN", product);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/findByNameLike.do")
    public @ResponseBody
    List<Product> findByNameLke(@RequestParam(name = "likes") String nameLike) {
        return ips.findProductByNameLike(nameLike);
    }

    @RequestMapping("findByAll.do")
    public ModelAndView findByAll(){
        ModelAndView mv=new ModelAndView();
       List<Product> productList= ips.findProductByAll();
       mv.addObject("productlists",productList);
       mv.setViewName("product-list1");
       return mv;
    }

}
