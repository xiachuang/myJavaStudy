package cn.hdj.contollerMybatis;

import cn.hdj.domain.User;
import cn.hdj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController01 {

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/query01")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> list=userMapper.queryUserList();
        return  list;
    }

}
