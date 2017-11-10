package com.tmall.service;

import com.tmall.pojo.Property;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface PropertyService {
    void add(Property c);

    void delete(int id);

    void update(Property c);

    Property get(int id);

    List list(int cid);
}
