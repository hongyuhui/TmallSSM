package com.tmall.service;

import com.tmall.pojo.User;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);
    User get(String name, String password);
}
