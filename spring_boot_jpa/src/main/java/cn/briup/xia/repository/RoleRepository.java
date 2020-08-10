package cn.briup.xia.repository;

import cn.briup.xia.baen.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Integer> {
}
