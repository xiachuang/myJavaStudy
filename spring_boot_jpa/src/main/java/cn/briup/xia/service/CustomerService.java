package cn.briup.xia.service;

import cn.briup.xia.baen.Customer;

import java.util.List;
import java.util.Optional;

/*
*   账号管理操作
 */
public interface CustomerService {
    public List<Customer> findByAll();
    public Customer findCustById(Integer id);
    public Boolean insertCustomer(Customer customer);
    public Customer findCustomerByName(String custName);
    public void delectCustomerById(Integer id);
    public void delectBookByCustomerId(Integer bookId,Integer custId);
    public void delectComicByCustomerId(Integer comicId,Integer custId);
    public  void insetBookByCutsomerId(Integer BookId,Integer custid);
    public  void insertComicByCustomerId(Integer comicId,Integer custid);
}
