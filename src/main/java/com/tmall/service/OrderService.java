package com.tmall.service;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order c);

    float add(Order c, List<OrderItem> ois);
    void delete(int id);
    void update(Order c);
    Order get(int id);
    List list();
    List list(int uid, String excludedStatus);
}
