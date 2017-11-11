package com.tmall.service;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface OrderItemService {
    void add(OrderItem c);

    void delete(int id);
    void update(OrderItem c);
    OrderItem get(int id);
    List list();

    void fill(List<Order> os);

    void fill(Order o);

    int getSaleCount(int pid);
}
