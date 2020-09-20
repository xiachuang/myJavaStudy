package cn.briup.cache.controller;

import cn.briup.cache.bean.Department;
import cn.briup.cache.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping("/findDeptId")
    public Department findDepartById(@RequestParam("id")Integer id){
        Department department=departmentService.findDeptById(id);
        return  department;
    }
    @GetMapping("/updateDept")
    public Department updateDept(Department department){
     return    departmentService.updateDept(department);

    }

}
