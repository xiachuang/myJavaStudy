package cn.briup.jpa.servie;

import cn.briup.jpa.bean.Department;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface DepartmentService {
    public List<Department> findAll();
    public Department findDeptById(Integer id);
    public Integer deleteDeptById(Integer id);
    public Department updateDept(Department department);
    public  Department insertDept(Department department);
}
