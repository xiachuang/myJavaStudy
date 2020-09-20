package cn.briup.xia.controller;

import cn.briup.xia.bean.Employee;
import cn.briup.xia.service.IEmployeeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService ies;
    @RequestMapping("/emp/all")
    public List<Employee> findAll(){
        List<Employee> list=ies.findByAll();
        return  list;
    }
    @GetMapping("/emp/like")
    public  List<Employee> findEmpLike(@RequestParam("lastName") String name){
       List<Employee> list= ies.findByNameLike(name);
        return list;
    }
    @GetMapping("/emp")
    public Employee findByid(@RequestParam("id") Integer id){
        Employee employee=ies.findEmpById(id);
        return employee;
    }
    @RequestMapping("/emp/insert")
    public  Boolean insertEmp(){
        Employee employee=new Employee();
        employee.setLastName("詹姆斯");
        employee.setGender(1);
        employee.setEmail("2321312@cc");
        Boolean bl=ies.insertEmp(employee);
        return  bl;
    }
    @RequestMapping("/emp/update")
    public Boolean updateEmp(@RequestParam("lastName") String name,@RequestParam("id") Integer id){
        Boolean bl=ies.updateEmp(name, id);
        return bl;
    }
}
