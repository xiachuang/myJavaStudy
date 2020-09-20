package cn.briup.cache.Mapper;

import cn.briup.cache.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IDepartmentMapper {

    @Select("select * from department")
    public List<Department> findByAll();
    @Select("select * from department where id=#{id}")
    public  Department findDeptById(Integer id);
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public  void updateDept(Department department);
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public Department insertDept(Department department);
    @Delete("delete department where id=#{id}")
    public  Integer deltetDept(Integer id);
}
