package cn.hdj.ssm.service;

import cn.hdj.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findByAll();
    public  Boolean save(Permission permission);
}
