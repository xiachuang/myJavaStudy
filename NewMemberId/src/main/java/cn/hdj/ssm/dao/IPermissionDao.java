package cn.hdj.ssm.dao;

import cn.hdj.ssm.domain.Permission;
import cn.hdj.ssm.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(Integer id);
    @Select("select * from permission ")
    public List<Permission> findByAll();
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    public int save(Permission permission);
}
