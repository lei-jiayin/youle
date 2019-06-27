package com.youle.item.service;

import com.youle.common.enums.ExceptionEnums;
import com.youle.common.exception.YlException;
import com.youle.item.mapper.CategoryMapper;
import com.youle.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xw
 * @date 2019-05-29 22:23
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListById(Long pid) {
        // 查询条件，mapper会把对象中的非空属性作为查询条件
        Category t = new Category();
        t.setParentId(pid);
        List<Category> list = categoryMapper.select(t);
        // 判断查询结果是否为空
        if (CollectionUtils.isEmpty(list)){
            throw new YlException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return list;
    }

    public List<Category> queryByIds(List<Long> ids){
        List<Category> categories = categoryMapper.selectByIdList(ids);
        if (CollectionUtils.isEmpty(categories)){
            throw new YlException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return categories;
    }
}
