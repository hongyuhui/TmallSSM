package com.tmall.service.impl;

import com.tmall.mapper.OrderItemMapper;
import com.tmall.pojo.*;
import com.tmall.service.OrderItemService;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;
    @Autowired
    ProductImageService productImageService;
    @Override
    public void add(OrderItem c) {
        orderItemMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(OrderItem c) {
        orderItemMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }
    @Override
    public List list() {
        OrderItemExample example = new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
    }

    @Override
    public void fill(List<Order> os) {
        for (Order o : os) {
            fill(o);
        }
    }

    @Override
    public void fill(Order o) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andOidEqualTo(o.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> ois =orderItemMapper.selectByExample(example);
        setProduct(ois);

        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi : ois) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();
        }
        o.setTotal(total);
        o.setTotalNumber(totalNumber);
        o.setOrderItems(ois);
    }
    public void setProduct(List<OrderItem> ois){
        for (OrderItem oi: ois) {
            setProduct(oi);
        }

    }

    private void setProduct(OrderItem oi) {
        Product p = productService.get(oi.getPid());
        setFirstProductImage(p);
        System.out.println("aaaaaaaaaaaaaaaaa");
        System.out.println(p.getName());
        System.out.println(p.getFirstProductImage());
        oi.setProduct(p);
    }
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis = productImageService.list(p.getId(), ProductImageService.type_single);
        System.out.println(pis.isEmpty());
        if (!pis.isEmpty()) {
            ProductImage pi = pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
    public void setFirstProductImage(List<Product> ps) {
        for (Product p : ps) {
            setFirstProductImage(p);
        }
    }
}
