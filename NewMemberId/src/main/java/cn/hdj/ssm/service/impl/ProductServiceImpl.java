package cn.hdj.ssm.service.impl;

import cn.hdj.ssm.dao.IProductDao;
import cn.hdj.ssm.domain.Product;
import cn.hdj.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private  IProductDao ipd;

    @Override
    public Product findProductById(Integer id) {
     Product p=   ipd.findProductById(id);
        return p;
    }

    @Override
    public List<Product> findProductByAll() {
        List<Product> listp=ipd.findProductByAll();
        return listp;
    }

    @Override
    public Product findProductByName(String name) {
        Product p=ipd.findProductByName(name);
        return p;
    }

    @Override
    public List<Product> findProductByNameLike(String likename) {
        List<Product> lists=ipd.findProductByNameLike(likename);
        return lists;
    }

    @Override
    public Boolean saveProduct(Product product) {
       int rows=ipd.save(product);
       Boolean bl=null;
       if(rows>0){
           bl=true;
       }else {
           bl=false;
       }
        return bl;
    }

    @Override
    public Boolean delectProductByid(Integer id) {
        int rows=ipd.delectById(id);
        Boolean bl=null;
        if(rows>0){
            bl=true;
        }else {
            bl=false;
        }
        return bl;
    }

    @Override
    public Boolean updateProductByid(String productName, Integer id) {
        int rows=ipd.updateNameById(productName,id);
        Boolean bl=null;
        if(rows>0){
            bl=true;
        }else {
            bl=false;
        }
        return bl;
    }
}
