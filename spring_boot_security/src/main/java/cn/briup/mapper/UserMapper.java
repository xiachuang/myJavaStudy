package cn.briup.mapper;

import cn.briup.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

//@Mapper
public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public int insertUser(User user);

    @Select("select * from where id=#{id}")
    @Results(
            @Result(id = true,property = "id",column = "id")
    )
    public User findById(Integer id);
}
