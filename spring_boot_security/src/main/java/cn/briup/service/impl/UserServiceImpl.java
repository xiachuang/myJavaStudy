package cn.briup.service.impl;

import cn.briup.bean.User;
import cn.briup.mapper.UserMapper;
import cn.briup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insertUser(User user) {
        if(user==null){
            return 0;
        }else{
            String pwd=passwordEncoder.encode(user.getPassword());
            System.out.println(pwd);
            user.setPassword(pwd);
            System.out.println(user);
            int rows=userMapper.insertUser(user);
            return rows;
        }

//        String pwd=passwordEncoder.encode(user.getPassword());
//        System.out.println(pwd);


    }
}
