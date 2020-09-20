package cn.briup.xia.controller;

import cn.briup.xia.bean.Department;
import cn.briup.xia.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private IDepartmentService ids;
    @RequestMapping("/dept/all")
    public List<Department> findByAll(){
       List<Department> list= ids.findByAll();
        return list;
    }
    @RequestMapping("/dept/like")
    public  List<Department> findBynamelike(@RequestParam("deptName") String name){
       List<Department> list= ids.findByNameLike(name);
        return  list;
    }
    @RequestMapping("/dept/findId")
    public  Department findById(@RequestParam("id")Integer id){
        Department department=ids.findDepartmentById(id);
        return  department;
    }
    @RequestMapping("/dept/insert")
    public Boolean insertDept(){
        Department department=new Department();
        department.setDepartmentName("企划");
        Boolean bl=ids.insertDepart(department);
        return  bl;
    }
    @RequestMapping("dept/update")
    public Boolean updateDept(@RequestParam("deptName") String name,@RequestParam("id") Integer id){
      Boolean bl=  ids.updateDepart(name, id);
      return  bl;
    }
}
