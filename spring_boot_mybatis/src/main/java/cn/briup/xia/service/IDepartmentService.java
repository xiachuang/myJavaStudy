package cn.briup.xia.service;

import cn.briup.xia.bean.Department;


import java.util.List;

public interface IDepartmentService{
    public List<Department> findByAll();
    public List<Department> findByNameLike(String name);
    public Department findDepartmentById(Integer id);
    public  Boolean deleteDepartById(Integer id);
    public  Boolean insertDepart(Department department);
    public  Boolean updateDepart(String name,Integer id);
}









