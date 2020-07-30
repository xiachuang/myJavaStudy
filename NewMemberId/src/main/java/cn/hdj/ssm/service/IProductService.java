package cn.hdj.ssm.service;

import cn.hdj.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    public Product findProductById(Integer id);
    public List<Product> findProductByAll();
    public Product findProductByName(String name);
    public List<Product> findProductByNameLike(String likename);
    public Boolean saveProduct(Product product);
    public Boolean delectProductByid(Integer id);
    public Boolean updateProductByid(String productName,Integer id);

}
