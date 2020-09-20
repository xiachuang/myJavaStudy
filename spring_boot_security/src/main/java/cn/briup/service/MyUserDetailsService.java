package cn.briup.service;

import cn.briup.bean.Role;
import cn.briup.bean.User;
import cn.briup.mapper.User_RoleMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private User_RoleMapper user_roleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        User user=user_roleMapper.findUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        System.out.println(user);
        List<Role> roles=user_roleMapper.findRoleByUserId(user.getId());
        for(Role r:roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+r.getName()));
        }
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorities);
    }
}
