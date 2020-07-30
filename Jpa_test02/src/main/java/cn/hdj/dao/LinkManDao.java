package cn.hdj.dao;

import cn.hdj.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LinkManDao extends JpaRepository<LinkMan,Integer>, JpaSpecificationExecutor<LinkMan> {
}
