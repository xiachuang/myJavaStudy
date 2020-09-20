package cn.briup.cache.Mapper;

import cn.briup.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IEmployeeMapper {
    @Select("select * from employee")
    public List<Employee> findByAll();
    @Select(("select * from employee where id=#{id}"))
    public Employee findEmpById(Integer id);
    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);
    @Delete("delete from employee where id=#{id}")
    public  void deleteEmp(Integer id);
    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public  void updateEmp(Employee employee);
    @Select("select * from employee where lastName=#{lastName}")
    public  Employee getEmpByName(String name);
}
