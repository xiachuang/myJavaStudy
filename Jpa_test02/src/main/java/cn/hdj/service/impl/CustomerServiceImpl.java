package cn.hdj.service.impl;

import cn.hdj.dao.CustomerDao;
import cn.hdj.domain.Customer;
import cn.hdj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao cd;
    public List<Customer> findCustomerAll() {
        List<Customer> list=cd.findAll();
        for(Customer c:list){
            System.out.println(c);
        }
        return list;
    }
}
