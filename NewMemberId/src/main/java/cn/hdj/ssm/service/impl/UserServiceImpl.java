package cn.hdj.ssm.service.impl;

import cn.hdj.ssm.dao.IUserDao;
import cn.hdj.ssm.domain.Role;
import cn.hdj.ssm.domain.UserInfo;
import cn.hdj.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private  IUserDao iud;
//    @Autowired
//    private  BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public UserInfo findUserByUserName(String userName) {
//        UserInfo userInfo =iud.findUserByName(userName);
//        System.out.println(userInfo);
//        return userInfo;
//    }

    @Override
    public UserInfo findUserById(Integer userId) {
        UserInfo userInfo=iud.findUserById(userId);
        System.out.println(userInfo);
        return userInfo;
    }

    @Override
    public List<UserInfo> findByAll() {
        List<UserInfo> list=iud.findByAll();
        return list;
    }

    @Override
    public Boolean save(UserInfo userInfo) {
//        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        Boolean bl=false;
        int rows=iud.save(userInfo);
        if(rows>0){
            bl=true;
        }
        System.out.println(bl);
        return bl;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = iud.findUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }
    //作用返回一个集合
    //SimpleGrantedAuthority
    public  List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for(Role r:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName().toUpperCase()));

        }
        return list;
    }
}
