package com.tmall.mapper;

import com.tmall.pojo.Category;
import com.tmall.util.Page;

import java.util.List;

/**
 * Created by OovEver on 2017/11/9.
 */
public interface CategoryMapper {
    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);

}
