package cn.briup.cache.service;

import cn.briup.cache.bean.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> findByAll();
    public  Employee findEmpById(Integer id);
    public  Employee updateEmp(Employee employee);
    public  Integer insertEmp(Employee employee);
    public  Integer deleteEmp(Integer id);
    public  Employee getEmpByName(String name);
}
