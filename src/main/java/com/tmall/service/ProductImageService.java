package com.tmall.service;

import com.tmall.pojo.ProductImage;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
public interface ProductImageService {
    String type_single = "type_single";
    String type_detail = "type_detail";

    void add(ProductImage productImage);

    void delete(int id);

    void update(ProductImage productImage);

    ProductImage get(int id);
//根据产品id和图片类型查询的list方法
    List list(int pid, String type);
}
