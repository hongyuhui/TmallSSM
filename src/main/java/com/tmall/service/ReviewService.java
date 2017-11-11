package com.tmall.service;

import com.tmall.pojo.Review;

import java.util.List;

/**
 * Created by OovEver on 2017/11/11.
 */
public interface ReviewService {
    void add(Review c);

    void delete(int id);
    void update(Review c);
    Review get(int id);
    List list(int pid);

    int getCount(int pid);
}
