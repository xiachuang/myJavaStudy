package cn.hdj.ssm.service;

import cn.hdj.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    public Boolean save(Role role);
    public List<Role> findByAll();
}
