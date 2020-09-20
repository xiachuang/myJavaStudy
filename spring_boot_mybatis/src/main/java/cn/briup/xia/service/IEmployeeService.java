package cn.briup.xia.service;

import cn.briup.xia.bean.Employee;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> findByAll();
    public List<Employee> findByNameLike(String name);
    public  Employee findEmpById(Integer id);
    public  Boolean insertEmp(Employee employee);
    public Boolean updateEmp(String name,Integer id);
}
