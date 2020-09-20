package cn.briup.cache.service.impl;
import cn.briup.cache.Mapper.IEmployeeMapper;
import cn.briup.cache.bean.Employee;
import cn.briup.cache.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
//@CacheConfig(cacheNames = "emp") 抽取公共配置
public class EmployeeServiceImpl   implements IEmployeeService{
    @Autowired
    private IEmployeeMapper emp;
    @Override
    public List<Employee> findByAll() {
        List<Employee> employeeList=emp.findByAll();
        return employeeList;
    }
    @Override
//   @Cacheable(value = {"emp"},key = "#id")
    //@Cacheable(value={"emp"},key="#root.methodName+'['+#id+']'")
    //@Cacheable(value={"emp"},keyGenerator="myGenerator")自定义的key生成器
//    @Cacheable(value = {"emp","emp1"},key="#id")//可以存两个那么 cacaheNames也可以 root.args[0]
    //condition 判断执行是否缓存
    @Cacheable(value = {"emp"},key="#id",condition = "#id>2")
    public Employee findEmpById(Integer id) {
        Employee employee=emp.findEmpById(id);
        System.out.println("查询了"+id+"员工");
        return employee;

    }
    @Override
    @CachePut(value = {"emp"},key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp:"+employee);
        emp.updateEmp(employee);
        return employee;
    }


    @Override
    public Integer insertEmp(Employee employee) {
        emp.insertEmp(employee);
        System.out.println("保存成功");
        return employee.getId();
    }

    @Override
    @CacheEvict(value = {"emp"},beforeInvocation = true,key = "#id")
    public Integer deleteEmp(Integer id) {
        emp.deleteEmp(id);
        System.out.println("删除成功");
        return id;
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(value = {"emp"},key = "#name")
            },
            put = {
                    @CachePut(value = {"emp"},key = "#result.id"),
                    @CachePut(value = {"emp"},key = "#result.email")
            }
    )
    public Employee getEmpByName( String name) {
        Employee employee=emp.getEmpByName(name);
        System.out.println("查询"+name);
        return employee;
    }
}
