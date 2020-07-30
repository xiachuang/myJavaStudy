package cn.hdj.ssm.service;

import cn.hdj.ssm.domain.Orders;


import java.util.List;

public interface IOrdersService {
    //分页

    public List<Orders> findOrdersAll(int page,int size);
    public  Orders findOrdersById(Integer id);
}
