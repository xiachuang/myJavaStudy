package cn.briup.xia.Controller;


import cn.briup.xia.dao.DepartmentDao;
import cn.briup.xia.dao.EmployeeDao;
import cn.briup.xia.entities.Department;
import cn.briup.xia.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao ied;
    @Autowired
    private DepartmentDao dtd;
    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=ied.getAll();
        model.addAttribute("emps",employees);
     //thymeleaf 默认拼串
//       int c=(int)  Math.random()*10;
        return "emp/list";

    }
    @GetMapping("/emp")
    public  String toAddPage(Model model){
        //跳到添加页面

       Collection<Department> departments= dtd.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }
    //员工添加
    @PostMapping("/emp")
    public  String addEmp(Employee employee){
        ied.save(employee);
        return "redirect:/emps";
        //  /表示当前项目路径
//        return "forward: /emps";
    }
    @GetMapping("/emp/{id}")
    public  String toEditEmp(@PathVariable("id") Integer id, Model model){
    Employee employee=ied.get(id);
    model.addAttribute("emp",employee);
    Collection<Department> departments=dtd.getDepartments();
    model.addAttribute("depts",departments);
    return "emp/add";
    }

    //需要提交id
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("修改的员工：" +employee);
        ied.save(employee);
        return  "redirect:/emps";

    }
    //删除
    //利用@RequestParam 注解获取链接上的值
    @RequestMapping("/delete/map")
    public String deleteEmp(@RequestParam("id") Integer id){
        ied.delete(id);
        System.out.println("成功删除！！！");
        return "redirect:/emps";
    }
}
