package cn.briup.xia.repository;

import cn.briup.xia.baen.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
//    @Query(value = "from User where userName=?")
    @Query(value="select * from user where user_name=?",nativeQuery = true)
    public User checkUserByName(String name);
    @Query(value = "update user set user_password=?2 where user_name=?1",nativeQuery = true)
    @Modifying
    public int updateUserPwd(String name,String pwd);
}
