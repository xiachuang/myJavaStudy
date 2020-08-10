package cn.briup.xia.service;

import cn.briup.xia.baen.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findByAll();
    public Boolean insertRole(Role role);
    public void deleteRole(Integer id);
}
