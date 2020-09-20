package cn.briup.cache.controller;

import cn.briup.cache.bean.Employee;
import cn.briup.cache.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("/findById")
//    @Cacheable(value = {"emp"})
    public Employee findById(@RequestParam("empId") Integer id){
       Employee emp= iEmployeeService.findEmpById(id);
       return emp;
    }
    @GetMapping("/updateEmp")
    public Employee updateEmp(Employee employee){
        return    iEmployeeService.updateEmp(employee);

    }
    @GetMapping("/deleteEmp")
    public  Integer delteteEmp(@RequestParam("empId")Integer id){
        iEmployeeService.deleteEmp(id);
        return  id;
    }
    @GetMapping("insertEmp")
    public  int insertEmp(Employee employee){
      return   iEmployeeService.insertEmp(employee);
    }
    @GetMapping("getEmp")
    public  Employee getEmpByName(@RequestParam("lastName")String lastName){
        return iEmployeeService.getEmpByName(lastName);
    }
}
