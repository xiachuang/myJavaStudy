package cn.briup.xia.repository;

import cn.briup.xia.baen.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeRepository extends JpaRepository<Type,Integer>, JpaSpecificationExecutor<Type> {
}
