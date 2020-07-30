package cn.hdj.oneToMany;

import cn.hdj.dao.LinkManDao;
import cn.hdj.domain.LinkMan;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.hdj.dao.CustomerDao;
import cn.hdj.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private  CustomerDao cd;
    @Autowired
    private LinkManDao lmd;

    @Test
    @Transactional
    @Rollback(false)
    public void test01(){
        Customer c=new Customer();
        c.setCustName("无为");
        c.setCustAddress("北京");
        c.setCustIndustry("CEO");
        c.setCustPhone("1889134809");
        LinkMan lm=new LinkMan();
        lm.setLkmName("哔哩哔哩");
        lm.setLkmEmail("979879@qq.com");
        lm.setCustomer(c);
        c.getLinkMans().add(lm);
        cd.save(c);
        lmd.save(lm);
        System.out.println("success");
    }
    /**
     * 级联添加：保存一个客户的同时，保存客户的所有联系人
     *      需要在操作主体的实体类上，配置casacde属性
     */
    @Test
    @Transactional
    @Rollback(false)
    public void casdTest(){
        Customer c=new Customer();
        c.setCustName("张三丰");
        c.setCustAddress("昆仑");
        c.setCustPhone("1232134213");
        LinkMan lm=new LinkMan();
        lm.setLkmName("安恒");
        lm.setLkmEmail("232871974@ewq");
        lm.setLkmPhone("213142145");
        lm.setCustomer(c);
        c.getLinkMans().add(lm);
        cd.save(c);
        System.out.println("success");
    }
    @Test
    @Transactional
    @Rollback(false)
    public void save02(){
        Customer c=new Customer();
        c.setCustName("阿尔托莉雅");
        c.setCustSource("Fate/zero");
        LinkMan lk=new LinkMan();
        lk.setLkmName("老婆");
        lk.setLkmPosition("誓约之剑");
        lk.setCustomer(c);
        c.getLinkMans().add(lk);
        cd.save(c);
        System.out.println("success");
    }
    /**
     * 级联删除：
     *      删除1号客户的同时，删除1号客户的所有联系人
     */
    @Test
    @Transactional
    @Rollback(false)
    public void casdDelect(){
        Customer c=cd.findOne(1);
        cd.delete(c);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void specUpdaate(){
    Specification<LinkMan> spec=new Specification<LinkMan>() {
        @Override
        public Predicate toPredicate(Root<LinkMan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Path<Object> lkmId= root.get("lkmId");
            Predicate p=criteriaBuilder.equal(lkmId,2);
            return p;
        }
    };
    LinkMan l=lmd.findOne(spec);
    l.setLkmPhone("9988888");
    l.setLkmMemo("又的撒旦");
    lmd.save(l);
    }
    //-----------------------------------对象导航查询---------------------------
    //对象导航查询
    //could not initialize proxy - no Session
    //测试对象导航查询（查询一个对象的时候，通过此对象查询所有的关联对象）
    @Test
    @Transactional
    public void selectTest01(){
       Customer c= cd.getOne(8);

        System.out.println(c);
      Set<LinkMan> list= c.getLinkMans();
      for(LinkMan l:list){
          System.out.println(l);
      }
    }
    @Test
    @Transactional // 解决在java代码中的no session问题
    public void  testQuery2() {
        //查询id为1的客户
        Customer customer = cd.findOne(1);
        //对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkMans = customer.getLinkMans();

        System.out.println(linkMans.size());
    }
    @Test
    @Transactional
    @Rollback(false)
    public void testQury(){
       LinkMan lk= lmd.getOne(7);
     Customer c=  lk.getCustomer();
        System.out.println(c.getCustName());
    }
    @Test
    @Transactional
    @Rollback(false)
    public  void testSession(){
       Customer c= cd.getOne(11);
       Set<LinkMan> list=c.getLinkMans();
       for(LinkMan l:list){
           System.out.println(l.getLkmName());
       }
    }
    //一对多的测试
    @Test
    @Transactional
    @Rollback(false)
    public void saveLinkman(){
        Specification<Customer> spec=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               Path<Object> custName= root.get("custName");
               Predicate p=  criteriaBuilder.like(custName.as(String.class),"%夏%");
               return  p;
            }
        };
      List<Customer> cs= cd.findAll(spec);
      for (Customer c:cs){
          System.out.println(c.getCustName());
          LinkMan lk=new LinkMan();
          lk.setLkmMemo("北京传奇");
          lk.setLkmEmail("123214@sddas");
          lk.setLkmPhone("34867326");
          lk.setCustomer(c);
          c.getLinkMans().add(lk);
          cd.save(c);
      }
        System.out.println("success");
    }
    //联急查询
    @Test
    @Transactional
    @Rollback(false)
    public void selectCust(){
        Specification<Customer> spec=new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
             Path<Object>  custId=  root.get("custId");
             Predicate p=criteriaBuilder.equal(custId,1);
             return  p;
            }
        };
       Customer c= cd.findOne(spec);
       Set<LinkMan> lks=c.getLinkMans();
       for (LinkMan l:lks)
       {
           System.out.println(l);
       }
    }
}
