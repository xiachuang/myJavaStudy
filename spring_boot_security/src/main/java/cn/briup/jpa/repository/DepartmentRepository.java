package cn.briup.jpa.repository;

import cn.briup.jpa.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentRepository extends JpaRepository<Department,Integer>, JpaSpecificationExecutor<Department> {
}
