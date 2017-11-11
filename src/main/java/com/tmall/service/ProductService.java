package com.tmall.service;

import com.tmall.pojo.Category;
import com.tmall.pojo.Product;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface ProductService {
    void add(Product p);

    void delete(int id);

    void update(Product p);
//根据主键，显示特定产品信息
    Product get(int id);
//根据分类显示产品信息
    List list(int cid);
//    显示第一张图片
    void setFirstProductImage(Product p);

    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);

    void setSaleAndReviewNumber(Product p);

    void setSaleAndReviewNumber(List<Product> ps);
    List<Product> search(String keyword);
}
