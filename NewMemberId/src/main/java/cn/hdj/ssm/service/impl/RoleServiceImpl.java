package cn.hdj.ssm.service.impl;

import cn.hdj.ssm.dao.IRoleDao;
import cn.hdj.ssm.domain.Role;
import cn.hdj.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao ird;
    @Override
    public Boolean save(Role role) {
        int rows=ird.save(role);
        Boolean bl=false;
        if(rows>0){
            bl=true;
        }
        System.out.println(bl);
        return bl;
    }

    @Override
    public List<Role> findByAll() {
        List<Role> list=ird.findByAll();
        for(Role r:list){
            System.out.println(r);
        }
        return list;
    }
}
