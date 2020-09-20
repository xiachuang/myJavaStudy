package cn.briup;

import cn.briup.jpa.bean.Department;
import cn.briup.jpa.bean.Employee;
import cn.briup.jpa.repository.DepartmentRepository;
import cn.briup.jpa.repository.EmployeeRepository;
import cn.briup.jpa.servie.DepartmentService;
import cn.briup.jpa.servie.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class SpringBootSecurityApplicationTests {
    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Test
    void contextLoads() {
        String pwd=passwordEncoder.encode("123456");
        System.out.println(pwd);
    }
    @Test
    @Transactional
    @Rollback(false)
    public void save(){
        Employee employee=new Employee();
//       Department department=new Department();
        employee.setEmpName("肖宇");
        employee.setEmpAge(18);
        employee.setEmpSalary("10000");
        Department department1=departmentRepository.findById(2).get();
        employee.setDepartment(department1);
        department1.getEmployees().add(employee);
        employeeRepository.save(employee);
        System.out.println("success");
    }
    @Test
    public void findAll(){
    List<Department> departments= departmentService.findAll();
    for(Department de:departments){
        System.out.println(de);
        }
    }
    //-------------Emp  缓存操作
    @Test
    public void empFindAll(){
    List<Employee> employees=employeeService.findAll();
    for(Employee employee:employees){
        System.out.println(employee);
        }

    }
    @Test
    public void empFindById(){
    Employee employee=employeeService.findEmpById(8);
        System.out.println(employee);


        employeeService.insertEmp(employee,2);
        Employee employee2=employeeService.findEmpById(8);
        System.out.println(employee2);
    }
}
