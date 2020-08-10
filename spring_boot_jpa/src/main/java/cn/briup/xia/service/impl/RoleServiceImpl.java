package cn.briup.xia.service.impl;

import cn.briup.xia.baen.Role;
import cn.briup.xia.repository.RoleRepository;
import cn.briup.xia.service.RoleService;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findByAll() {
        List<Role> roles=roleRepository.findAll();
        return roles;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean insertRole(Role role) {
        Boolean bl=null;
        Role roles=roleRepository.save(role);
        if(roles!=null){
            bl=true;
        }
        return bl;
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
