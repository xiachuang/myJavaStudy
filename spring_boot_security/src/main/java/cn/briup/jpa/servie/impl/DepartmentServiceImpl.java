package cn.briup.jpa.servie.impl;

import cn.briup.jpa.bean.Department;
import cn.briup.jpa.bean.Employee;
import cn.briup.jpa.repository.DepartmentRepository;
import cn.briup.jpa.servie.DepartmentService;
import cn.briup.jpa.servie.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
//@CacheConfig(cacheNames = "dept")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentRepository departmentRepository;
    @Override
    @Cacheable(value = {"deptList"},key = "#root.methodName")
    public List<Department> findAll() {
        System.out.println("启动了");
    List<Department> departments= departmentRepository.findAll();
        return departments;
    }

    @Override
    @Cacheable(value ={"dept"},key = "#id")
    public Department findDeptById(Integer id) {
        System.out.println("启动了");
        Department department   = departmentRepository.findById(id).get();
        return department;
    }

    @Override
    @CacheEvict(value = {"dept"},key = "#id",beforeInvocation = true)
    public Integer  deleteDeptById(Integer id) {
        System.out.println("删除成功");
       departmentRepository.deleteById(id);
        return  id;
    }

    @Override
    @CachePut(value = {"dept"},key = "#result.deptId")
    public Department updateDept(Department department) {
       Department department1= findDeptById(department.getDeptId());
       department1.setDeptName(department.getDeptName());
       departmentRepository.save(department1);
        return department1;
    }

    @Override
    public Department insertDept(Department department) {
        departmentRepository.save(department);
        return department;
    }
}
