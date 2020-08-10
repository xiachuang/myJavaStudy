package cn.hdj.manytomany;

import cn.hdj.dao.RoleDao;
import cn.hdj.dao.UserDao;
import cn.hdj.domain.Role;
import cn.hdj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class ManyToManyTest {
    @Autowired
    private UserDao ud;
    @Autowired
    private RoleDao rd;

    @Test
    @Transactional
    @Rollback(false)
    public void save01(){
        User u=new User();
        u.setUserName("曦瑶");
        Role r=new Role();
        r.setRoleName("经理");
        r.setRoleLevel("1");
        u.getRoles().add(r);
        r.getUsers().add(u);
        ud.save(u);
        rd.save(r);
    }
    //联级保存
    @Test
    @Transactional
    @Rollback(false)
    public  void  cascadeSvae(){
        User u=new User();
        u.setUserName("郭靖");
        Role r=new Role();
        r.setRoleName("将军");
        r.setRoleLevel("3");
        u.getRoles().add(r);
        r.getUsers().add(u);
        ud.save(u);
    }
    //修改关系表
    @Test
    @Transactional
    @Rollback(false)
    public void update(){
        Role r=new Role();
        r.setRoleName("Boss");
        r.setRoleLevel("1");
        User u= ud.getOne(2);
        u.getRoles().add(r);
        r.getUsers().add(u);
        ud.save(u);
        System.out.println("success");
    }
    //测试保存
    @Test
    @Transactional
    @Rollback(false)
    public void saveone(){
        Role r=new Role();
        r.setRoleName("架构师");
        r.setRoleLevel("2");
        User u=new User();
        u.setUserName("五欸");
        r.getUsers().add(u);
        u.getRoles().add(r);
        ud.save(u);
        System.out.println("success");
    }
    @Test
    @Transactional
    @Rollback(false)
    public void delect01(){
        ud.delete(5);
        System.out.println("success");
    }
    //测试动态删除
    @Test
    @Transactional
    @Rollback(false)
    public void delect02(){
        Specification<User> spec=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Path<Object> userId= root.get(" userId");
            Predicate p=criteriaBuilder.equal(userId,6);
            return p;
            }
        };
        User u=ud.findOne(spec);
        ud.delete(u);
        System.out.println("success");
    }
    //---------------------------------------------------------------------------------
    //测试多对多查询
    @Test
    @Transactional
    @Rollback(false)
    public void findByuserName() {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Path<Object> userName=root.get("userName");
            Predicate p=criteriaBuilder.like(userName.as(String.class),"肖%");
            return  p;
            }
        };
       List<User> us= ud.findAll(spec);
       for(User u:us){
           System.out.println(u.getUserName());
          Set<Role> rs= u.getRoles();
          for(Role r:rs){
              System.out.println(r);
          }
       }
        System.out.println("success");
    }

    @Test
    @Transactional
    @Rollback(false)
    public  void deleteByRole(){
        User user=ud.findOne(2);
        Role role=rd.findOne(1);
        user.getRoles().remove(role);
        role.getUsers().remove(user);
        ud.save(user);
        User user1=ud.findOne(2);
        Set<Role> roles=user1.getRoles();
        for(Role r:roles){
            System.out.println(r);
        }
    }

}