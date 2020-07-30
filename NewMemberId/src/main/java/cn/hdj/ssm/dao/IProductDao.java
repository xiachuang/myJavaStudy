package cn.hdj.ssm.dao;

import cn.hdj.ssm.domain.Product;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IProductDao {
    @Select("select * from product where id=#{id}")
    public Product findProductById(Integer id);
    @Select("select * from product")
    public List<Product> findProductByAll();
    @Select("select * from product where productName=#{productName}")
    public Product findProductByName(String name);
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int save(Product product);
    @Delete("delect from product where id=#{id}")
    int delectById(Integer id);
    @Update("update product set productName=#{productName} where id=#{id}")
    int updateNameById(@Param("productName") String name,@Param("id") Integer id);
    //模糊查询
    @Select("select * from product where productName like CONCAT('%',#{productName},'%')")
    public List<Product> findProductByNameLike(String name);
}
