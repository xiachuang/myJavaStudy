package cn.briup.mapper;

import cn.briup.bean.Role;
import cn.briup.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface User_RoleMapper {
    @Select("select * from user where username=#{userName}")
    public User findUserByUserName(String userName);
    @Select("select * from role where id in(select roleId from user_role where userId=#{userId})")
    public List<Role> findRoleByUserId(Integer userId);
}
