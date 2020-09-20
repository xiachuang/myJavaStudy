package cn.briup.cache.service;

import cn.briup.cache.bean.Department;

public interface IDepartmentService {
    public Department findDeptById(Integer id);
    public Department insertDept(Department department);
    public Integer deleteDept(Integer id);
    public Department updateDept(Department department);
}
