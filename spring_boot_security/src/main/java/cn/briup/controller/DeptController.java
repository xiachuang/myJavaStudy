package cn.briup.controller;

import cn.briup.jpa.bean.Department;
import cn.briup.jpa.servie.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/finddeptAll")
    public List<Department> findAll(){
        List<Department> departments=departmentService.findAll();
        return departments;
    }
    @GetMapping("/findeptByid")
    public Department findByid(Integer id){
     Department department  = departmentService.findDeptById(id);
        return department;
    }
    @GetMapping("/deletedeptById")
    public String deleteByid(Integer id){
        departmentService.deleteDeptById(id);
        return "success";
    }
    @GetMapping("updateDept")
    public Department updataDept(Department department){
      return   departmentService.updateDept(department);
    }
    @GetMapping("insertDept")
    public  Department inset(Department department){
        return  departmentService.insertDept(department);
    }
}
