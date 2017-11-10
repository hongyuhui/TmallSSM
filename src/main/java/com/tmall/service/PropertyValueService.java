package com.tmall.service;

import com.tmall.pojo.Product;
import com.tmall.pojo.PropertyValue;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface PropertyValueService {
    void init(Product p);

    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);

    List<PropertyValue> list(int pid);
}
