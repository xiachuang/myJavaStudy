package cn.briup.xia.service.impl;

import cn.briup.xia.baen.Book;
import cn.briup.xia.baen.Comic;
import cn.briup.xia.baen.Customer;
import cn.briup.xia.exception.MyException;
import cn.briup.xia.repository.CustomerRepository;
import cn.briup.xia.service.BookService;
import cn.briup.xia.service.ComicService;
import cn.briup.xia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private ComicService comicService;
    @Override
    public List<Customer> findByAll() {
        List<Customer> customerList=customerRepository.findAll();
        return customerList;
    }

    @Override
    public Customer findCustById(Integer uid) {
        Specification<Customer> spec=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
             Path<Object> id= root.get("id");
             Predicate predicate=criteriaBuilder.equal(id,uid);
            return  predicate;
            }
        };
       Optional<Customer> customer= customerRepository.findOne(spec);
       if(customer.isPresent()){
           return customer.get();
       }else {
           throw  new MyException();
        }
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean insertCustomer(Customer customer) {
        Boolean bl=false;
       Customer customer1= customerRepository.save(customer);
       if(customer1.getCustName()!=null){
           bl=true;
       }
        return bl;
    }

    @Override
    public Customer findCustomerByName(String custName) {
     Customer customer= customerRepository.findCustomerByCustName(custName);
        return customer;
    }

    @Override
    public void  delectCustomerById(Integer id) {
       customerRepository.deleteById(id);
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean delectBookByCustomerId(Integer bookId, Integer custId) {
        Book book= bookService.findBookById(bookId);
        Customer customer=customerRepository.findById(custId).get();
        book.getCustomers().remove(customer);
        customer.getBooks().remove(book);
        customerRepository.save(customer);
        return true;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean delectComicByCustomerId(Integer comicId, Integer custId) {
            Comic comic=comicService.findComicById(comicId);
            Customer customer=customerRepository.findById(comicId).get();
            customer.getComics().remove(comic);
            comic.getCustomers1().remove(customer);
            customerRepository.save(customer);
            return true;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean insetBookByCutsomerId(Integer bookId, Integer custid) {
        Book book=bookService.findBookById(bookId);
        Customer customer=customerRepository.findById(custid).get();
        customer.getBooks().add(book);
        book.getCustomers().add(customer);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Boolean insertComicByCustomerId(Integer comicId, Integer custid) {
        Comic comic=comicService.findComicById(comicId);
        Customer customer=customerRepository.findById(custid).get();
        customer.getComics().add(comic);

        comic.getCustomers1().add(customer);


        customerRepository.save(customer);
        return true;
    }
}
