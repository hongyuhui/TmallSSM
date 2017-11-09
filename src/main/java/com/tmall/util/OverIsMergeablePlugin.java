package com.tmall.util;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by OovEver on 2017/11/9.
 * MybatisGenerator插件是Mybatis官方提供的，这个插件存在一个固有的Bug，及当第一次生成了CategoryMapper.xml之后，再次运行会导致CategoryMapper.xml生成重复内容，而影响正常的运行。
 为了解决这个问题，需要自己写一个小插件类OverIsMergeablePlugin。 它为什么起作用说起来比较复杂，不在这里展开了，反正。。。我也是复制粘贴来的~
 至于怎么使用，将在下一个步骤generatorConfig.xml讲解，这里先准备这个类。
 */
public class OverIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}