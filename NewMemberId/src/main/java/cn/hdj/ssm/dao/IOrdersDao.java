package cn.hdj.ssm.dao;

import cn.hdj.ssm.domain.Member;
import cn.hdj.ssm.domain.Orders;
import cn.hdj.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.hdj.ssm.IProductDao.findProductById")),
    })
    public List<Orders> findOrdersAll();
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.hdj.ssm.dao.IProductDao.findProductById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many=@Many(select = "cn.hdj.ssm.dao.ITravellerDao.findByOrdersId")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "cn.hdj.ssm.dao.IMemberDao.findMemberById"))
    })
    public Orders findOrdersById(Integer id);

}
