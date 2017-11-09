package com.tmall.service.impl;

import com.tmall.mapper.CategoryMapper;
import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;
import com.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OovEver on 2017/11/9.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }




    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.delete(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }

}
