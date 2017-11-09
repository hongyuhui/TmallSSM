package com.tmall.service.impl;

import com.tmall.mapper.CategoryMapper;
import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;
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
    public List<Category>  list() {
        return categoryMapper.list();
    }

}
