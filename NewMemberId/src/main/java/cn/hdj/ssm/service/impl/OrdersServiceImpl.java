package cn.hdj.ssm.service.impl;

import cn.hdj.ssm.dao.IOrdersDao;
import cn.hdj.ssm.domain.Orders;
import cn.hdj.ssm.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ido;
    @Override
    public List<Orders> findOrdersAll(int page,int size) {
        //分页
        PageHelper.startPage(page,size);
        List<Orders> ordersList=ido.findOrdersAll();
        return ordersList;
    }

    @Override
    public Orders findOrdersById(Integer id) {
       Orders orders= ido.findOrdersById(id);

        return orders;
    }
}
