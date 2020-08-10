package cn.briup.xia.repository;

import cn.briup.xia.baen.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComIcRepository extends JpaRepository<Comic,Integer>, JpaSpecificationExecutor<Comic> {
}
