package cn.hdj.ssm.service;

import cn.hdj.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
   // public UserInfo findUserByUserName(String userName);
    public UserInfo findUserById(Integer userId);
    public List<UserInfo> findByAll();
    public Boolean save(UserInfo userInfo);
}
