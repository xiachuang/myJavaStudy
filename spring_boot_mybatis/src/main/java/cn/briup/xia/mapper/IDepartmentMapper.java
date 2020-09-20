package cn.briup.xia.mapper;

import cn.briup.xia.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;
//@Mapper
//使用MapperScan批量扫描
@Mapper
public interface IDepartmentMapper {
    @Select("select * from department")
    public List<Department> findByAll();
    //模糊查询  @Select("select * from product where productName like CONCAT('%',#{productName},'%')")
    @Select("select * from department where departmentName like CONCAT('%',#{departmentName},'%')")
    public  List<Department> findByNameLike(String deName);
    @Select("select * from department where id=#{id}")
    public  Department findDepartmentById(Integer id);
    @Delete("delete from department where id=#{id}")
    public int deleteDepartById(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public  int insertDepart(Department department);
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public  int updateDepart(@Param("departmentName") String name,@Param("id") Integer id);
//    final static int c=100;
}
