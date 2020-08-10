package cn.hdj.test;
import cn.hdj.dao.CustomerDao;
import cn.hdj.dao.LinkManDao;
import cn.hdj.domain.Customer;
import cn.hdj.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class SpecTest {
    @Autowired
    private CustomerDao cd;
    @Autowired
    private LinkManDao lkm;
    @Test
    public void testspec(){
        /**
         * 自定义查询条件
         *      1.实现Specification接口（提供泛型：查询的对象类型）
         *      2.实现toPredicate方法（构造查询条件）
         *      3.需要借助方法参数中的两个参数（
         *          root：获取需要查询的对象属性
         *          CriteriaBuilder：构造查询条件的，内部封装了很多的查询条件（模糊匹配，精准匹配）
         *       ）
         *  案例：根据客户名称查询，查询客户名为传智播客的客户
         *          查询条件
         *              1.查询方式
         *                  cb对象
         *              2.比较的属性名称
         *                  root对象
         *
         */
        Specification<Customer> spec=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Path<Object> custName=root.get("custName");
               Predicate p= cb.equal(custName,"夏创");
                return p;
            }
        };
      Customer c=  cd.findOne(spec);
        System.out.println(c);
    }
    /**
     * 多条件查询
     *      案例：根据客户名（传智播客）和客户所属行业查询（it教育）
     *
     */
    @Test
    public void testSpec01(){
        Specification<Customer> spec=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cbr) {
              Path<Object> custName= root.get("custName");
              Path<Object> custIndustry=root.get("custIndustry");
             Predicate p= cbr.equal(custName,"夏创");
             Predicate p1= cbr.equal(custIndustry,"学生");
             Predicate p3=cbr.and(p,p1);
                return p3;
            }
        };
        Customer c=cd.findOne(spec);
        System.out.println(c.getCustAddress());
    }
    /**
     * 案例：完成根据客户名称的模糊匹配，返回客户列表
     *      客户名称以 ’传智播客‘ 开头
     *
     * equal ：直接的到path对象（属性），然后进行比较即可
     * gt，lt,ge,le,like : 得到path对象，根据path指定比较的参数类型，再去进行比较
     *      指定参数类型：path.as(类型的字节码对象)
     */
    @Test
    public void testSpec02(){
        Specification<Customer> spec=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName=root.get("custName");
               Predicate p= criteriaBuilder.like(custName.as(String.class),"%夏%");
                return p;
            }
        };
        //添加排序
        //创建排序对象,需要调用构造方法实例化sort对象
        //第一个参数：排序的顺序（倒序，正序）
        //   Sort.Direction.DESC:倒序
        //   Sort.Direction.ASC ： 升序
        //第二个参数：排序的属性名称
        Sort sort=new Sort(Sort.Direction.DESC,"custId");
        List<Customer> list=cd.findAll(spec,sort);
        for(Customer c:list){
            System.out.println(c.getCustName());
        }
    }
    /**
     * 分页查询
     *      Specification: 查询条件
     *      Pageable：分页参数
     *          分页参数：查询的页码，每页查询的条数
     *          findAll(Specification,Pageable)：带有条件的分页
     *          findAll(Pageable)：没有条件的分页
     *  返回：Page（springDataJpa为我们封装好的pageBean对象，数据列表，共条数）
     */
    @Test
    public void testSpec3(){
        //分页
        Specification<Customer> spec=null;
        PageRequest page=new PageRequest(0,2);
        Page<Customer> pages=cd.findAll(null,page);
        System.out.println(pages.getTotalElements());//总条数
        System.out.println(pages.getContent());//集合列表
        System.out.println(pages.getTotalPages());//总页数
    }
    @Test
    public void testSpec4(){
        Specification<LinkMan> spec=new Specification<LinkMan>() {
            @Override
            public Predicate toPredicate(Root<LinkMan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               Path<Object> lkmName= root.get("lkmName");
              Predicate p= criteriaBuilder.like(lkmName.as(String.class),"%里%");
                return p;
            }
        };
        Sort sort=new Sort(Sort.Direction.DESC,"lkmId");
       List<LinkMan> list=lkm.findAll(spec,sort);
       for(LinkMan l:list){
           System.out.println(l);
       }
    }
}
