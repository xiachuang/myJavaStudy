package cn.briup.xia.mapper;



import cn.briup.xia.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
//@Mapper
public interface IEmployeeMapper {
   @Select("select * from employee")
    public List<Employee> findByAll();
   @Select("select * from employee where lastName like CONCAT('%',#{lastName},'%')")
    public List<Employee> findByNameLike(String name);
   @Select("select * from employee where id=#{id}")
    public  Employee findEmpById(Integer id);
   @Options(useGeneratedKeys = true,keyProperty = "id")
   @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    public  int insertEmp(Employee employee);
   @Update("update employee set lastName=#{lastName} where id=#{id}")
    public int updateEmp(@Param("lastName")String lastName,@Param("id") Integer id);

}
