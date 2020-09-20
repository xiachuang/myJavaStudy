package cn.briup.jpa.servie.impl;

import cn.briup.jpa.bean.Department;
import cn.briup.jpa.bean.Employee;
import cn.briup.jpa.repository.EmployeeRepository;
import cn.briup.jpa.servie.DepartmentService;
import cn.briup.jpa.servie.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeRepository employeeRepository;
    @Resource
    DepartmentService departmentService;
    @Override
    @Cacheable(value = {"empList"},key = "#root.methodName")
    public List<Employee> findAll() {
        System.out.println("启动了");

        List<Employee> employees=employeeRepository.findAll();
        return employees;
    }

    @Override
    @Cacheable(value = {"emp"},key = "#id")
    public Employee findEmpById(Integer id) {
        System.out.println("启动了");

        Employee employee= employeeRepository.findById(id).get();
        return employee;
    }
    //把一个员工添加到一个部门中去
    @Override
    public Employee insertEmp(Employee employee, Integer deptId) {
    Department department= departmentService.findDeptById(deptId);
    Employee employee1=findEmpById(employee.getEmpId());
    employee1.setEmpName(employee.getEmpName());
    employee1.setEmpAge(employee.getEmpAge());
    employee1.setEmpSalary(employee.getEmpSalary());
    employee1.setDepartment(department);
    department.getEmployees().add(employee1);
    employeeRepository.save(employee1);
    return employee1;
    }


}
