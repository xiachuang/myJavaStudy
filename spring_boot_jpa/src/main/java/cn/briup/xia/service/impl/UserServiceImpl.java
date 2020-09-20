package cn.briup.xia.service.impl;

import cn.briup.xia.baen.Customer;
import cn.briup.xia.baen.User;
import cn.briup.xia.repository.UserRepository;
import cn.briup.xia.service.CustomerService;
import cn.briup.xia.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository ur;
    @Autowired
    private CustomerService customerService;
//    @Rollback(false)
    @Override
    public String checkUserName(String name) {
        String psw="";
        User user=ur.checkUserByName(name);
        if(user.getUserPassword()==null){
            psw=null;
        }else{
            psw=user.getUserPassword();
            System.out.println(psw);
        }

        return psw;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean updateUserPwd(String name, String pwd) {
        int rows=ur.updateUserPwd(name,pwd);
        Boolean bl=false;
        if(rows>0){
            bl=true;
        }
        return true;
    }
    //创建用户
    @Override
    @Transactional
    @Rollback(false)
    public Boolean insertUser(User user) {
        User save = ur.save(user);
        Boolean bl=false;
        if(save!=null){
            bl=true;
        }
        return true;
    }
    //创建账户
    @Override
    @Transactional
    @Rollback(false)
    public Boolean insertCustomer(Customer customer, Integer userId) {
        Boolean bl=false;
        /*
         查询
            JPA 查空不报错  返回控制
         */
        Customer customer1=customerService.findCustomerByName(customer.getCustName());
        if(customer1==null) {
            User user = ur.getOne(userId);
            user.getCustomers().add(customer);
            ur.save(user);
             bl = true;
            return bl;
        }else{
            return bl;
        }
    }
}
