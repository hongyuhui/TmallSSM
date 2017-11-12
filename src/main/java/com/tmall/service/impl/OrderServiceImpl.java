package com.tmall.service.impl;

import com.tmall.mapper.OrderMapper;
import com.tmall.pojo.Order;
import com.tmall.pojo.OrderExample;
import com.tmall.pojo.OrderItem;
import com.tmall.pojo.User;
import com.tmall.service.OrderItemService;
import com.tmall.service.OrderService;
import com.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OovEver on 2017/11/11.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper      orderMapper;
    @Autowired
    UserService      userService;
    @Autowired
    OrderItemService orderItemService;
    @Override
    public void add(Order c) {
        orderMapper.insert(c);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public float add(Order c, List<OrderItem> ois) {
        float total = 0;
        add(c);
        if(false)
            throw new RuntimeException();
        for (OrderItem oi: ois) {
            oi.setOid(c.getId());
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order c) {
        orderMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result = orderMapper.selectByExample(example);
        setUser(result);
        return result;
    }

    public void setUser(List<Order> os){
        for (Order o : os)
            setUser(o);
    }
    public void setUser(Order o){
        int  uid = o.getUid();
        User u   = userService.get(uid);
        o.setUser(u);
    }
}
