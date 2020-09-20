package cn.briup.jpa.servie;

import cn.briup.jpa.bean.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findEmpById(Integer id);
    public  Employee insertEmp(Employee employee,Integer deptId);
}
