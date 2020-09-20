package cn.briup.xia;

import cn.briup.xia.baen.Comic;
import cn.briup.xia.baen.Customer;
import cn.briup.xia.repository.ComIcRepository;
import cn.briup.xia.repository.CustomerRepository;
import cn.briup.xia.repository.UserRepository;
import cn.briup.xia.service.BookService;
import cn.briup.xia.service.ComicService;
import cn.briup.xia.service.CustomerService;
import cn.briup.xia.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringBootJpaApplicationTests {
    @Autowired
    CustomerService customerService;
    @Autowired
    BookService bookService;
    @Autowired
    ComicService comicService;
    @Autowired
    RoleService roleService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
    }
//------------------------------------------customer--------------------------------------
    //查所有
    @Test
    public  void testCust(){
    List<Customer> set=customerService.findByAll();
    for(Customer c:set){
        System.out.println(c);
        }
    }
    @Test
    public void test(){
        System.out.println("-------------");//查询Id
        Set<Comic> comics=customerService.findCustById(2).getComics();
        for(Comic c:comics){
            System.out.println(c);
        }
//        Customer c=new Customer();
//        c.setCustName("华语");
//        c.setCustWay("网易");
//        customerService.insertCustomer(c);
//        System.out.println("success");
    }
    @Test
    public void test3(){
//        customerService.delectBookByCustomerId(1,2);
//        customerService.delectComicByCustomerId(1,1);
      customerService.insetBookByCutsomerId(3,5);
//    customerService.insertComicByCustomerId(1,5);
        System.out.println("success");
    }
//-------------------------------------user--------------------------------------
    @Test
    public void test04(){
        char c='a';
        short s=12;
        System.out.println(c*s);
    }
}
