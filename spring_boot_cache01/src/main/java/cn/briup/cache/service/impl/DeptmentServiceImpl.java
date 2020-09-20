package cn.briup.cache.service.impl;

import cn.briup.cache.Mapper.IDepartmentMapper;
import cn.briup.cache.bean.Department;
import cn.briup.cache.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeptmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentMapper departmentMapper;
    @Override
    @Cacheable(value = {"dept"},key = "#id")
    public Department findDeptById(Integer id) {
       Department department =departmentMapper.findDeptById(id);
        System.out.println("sucesss");
        return department;
    }

    @Override
    public Department insertDept(Department department) {

        return null;
    }

    @Override
    public Integer deleteDept(Integer id) {
        return null;
    }
    @CachePut(value = {"dept"},key = "#result.id")
    public Department updateDept(Department department){
    departmentMapper.updateDept(department);
        System.out.println(department.getId());
        return department;
    }
}
