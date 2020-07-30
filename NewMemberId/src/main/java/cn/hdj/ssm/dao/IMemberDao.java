package cn.hdj.ssm.dao;

import cn.hdj.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    public Member findMemberById(Integer id);
}
