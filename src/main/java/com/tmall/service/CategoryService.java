package com.tmall.service;

import com.tmall.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OovEver on 2017/11/9.
 */
@Service
public interface CategoryService {
    List<Category> list();
}
