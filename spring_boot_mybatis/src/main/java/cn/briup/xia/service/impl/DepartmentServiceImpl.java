package cn.briup.xia.service.impl;

import cn.briup.xia.bean.Department;
import cn.briup.xia.mapper.IDepartmentMapper;
import cn.briup.xia.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentMapper dmp;

    @Override
    public List<Department> findByAll() {
       List<Department> list= dmp.findByAll();
        return list;
    }

    @Override
    public List<Department> findByNameLike(String name) {
           List<Department> list=dmp.findByNameLike(name);
        return list;
    }

    @Override
    public Department findDepartmentById(Integer id) {
        Department department=dmp.findDepartmentById(id);
        return department;
    }

    @Override
    public Boolean deleteDepartById(Integer id) {
        Boolean bl=false;
        int rows=dmp.deleteDepartById(id);
        if(rows>0){
            bl=true;
        }
        return bl;
    }

    @Override
    public Boolean insertDepart(Department department) {
        Boolean bl=false;
        int rows=dmp.insertDepart(department);
        if(rows>0){
            bl=true;
        }
        return bl;
    }

    @Override
    public Boolean updateDepart(String name, Integer id) {
        Boolean bl=false;
        int rows=dmp.updateDepart(name,id);
        if(rows>0){
            bl=true;
        }
        return bl;
    }
}
