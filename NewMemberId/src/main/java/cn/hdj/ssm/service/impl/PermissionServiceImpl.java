package cn.hdj.ssm.service.impl;

import cn.hdj.ssm.dao.IPermissionDao;
import cn.hdj.ssm.domain.Permission;
import cn.hdj.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao ipd;
    @Override
    public List<Permission> findByAll() {
        List<Permission> list=ipd.findByAll();
        return list;
    }

    @Override
    public Boolean save(Permission permission) {
        int rows=ipd.save(permission);
        Boolean bl=false;
        if(rows>0){
            bl=true;
        }
        return bl;
    }
}
