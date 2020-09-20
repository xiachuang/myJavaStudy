package cn.briup.xia.service.impl;

import cn.briup.xia.bean.Employee;
import cn.briup.xia.mapper.IEmployeeMapper;
import cn.briup.xia.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeMapper iem;
    @Override
    public List<Employee> findByAll() {
        List<Employee> list=iem.findByAll();
        return list;
    }

    @Override
    public List<Employee> findByNameLike(String name) {
        List<Employee> list=iem.findByNameLike(name);
        return list;
    }


    @Override
    public Employee findEmpById(Integer id) {
        Employee employee=iem.findEmpById(id);
        return employee;
    }

    @Override
    public Boolean insertEmp(Employee employee) {
        int rows=iem.insertEmp(employee);
        Boolean bl=false;
        if(rows>0){
            bl=true;
        }
        return bl;
    }

    @Override
    public Boolean updateEmp(String name, Integer id) {
        int rows=iem.updateEmp(name, id);
        Boolean bl=false;
        if(rows>0){
            bl=true;
        }
        return bl;
    }
}
