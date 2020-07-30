package cn.hdj.test;
import cn.hdj.dao.CustomerDao;
import cn.hdj.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class CustomerServiceTest {
    @Autowired
    private CustomerDao cd;
    @Test
    public void findId(){
        Customer c=cd.findOne(1);
        System.out.println(c);

    }
    @Test
    public void findAll(){
        List<Customer> list=cd.findAll();
        for(Customer c:list){
            System.out.println(c);
        }
    }
    @Test
    @Transactional
    @Rollback(false)
    public  void save(){
        Customer c=new Customer();
        c.setCustName("华为");
        c.setCustAddress("北京");
        cd.save(c);
        System.out.println("success");
    }
    @Test
    public void delecte(){
        cd.delete(2);
        System.out.println("success");
    }
    @Test
    public void findCount(){
        Long count=cd.count();
        System.out.println(count);
    }
    @Test
    @Transactional
    public void getcustomer(){
       Customer c= cd.getOne(1);
        System.out.println(c);
    }
}
