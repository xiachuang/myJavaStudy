package cn.briup.xia.service;

import cn.briup.xia.baen.Customer;
import cn.briup.xia.baen.User;

public interface UserService {
    //校验登入
    public String checkUserName(String name);
    //修改密码
    public Boolean updateUserPwd(String name,String pwd);
    //注册
    public  Boolean insertUser(User user);
    //添加账号
    public  Boolean insertCustomer(Customer customer,Integer userId);
}
