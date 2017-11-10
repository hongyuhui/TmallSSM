package com.tmall.controller;

import com.tmall.pojo.Product;
import com.tmall.pojo.PropertyValue;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by OovEver on 2017/11/10.
 */
@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService       productService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model, int pid) {
        Product p = productService.get(pid);
//        初始化产品的属性
        propertyValueService.init(p);
        //    根据产品id获取所有的属性值
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "admin/editPropertyValue";
    }
//通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }
}

