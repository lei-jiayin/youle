package com.youle.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youle.common.enums.ExceptionEnums;
import com.youle.common.exception.YlException;
import com.youle.common.vo.PageResult;
import com.youle.item.mapper.SpuDetailMapper;
import com.youle.item.mapper.SpuMapper;
import com.youle.item.pojo.Brand;
import com.youle.item.pojo.Category;
import com.youle.item.pojo.Spu;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品货物处理类
 * @author xw
 * @date 2019/6/27 10:04
 */
@Service
public class GoodsService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;


    public PageResult<Spu> querySpuByPage(Integer page, Integer rows, String key, Boolean saleable) {
        // 分页
        PageHelper.startPage(page,rows);
        // 过滤
        Example example = new Example(Spu.class);
        Example.Criteria criteria =example.createCriteria();
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title","%"+key+"%");
        }
        if (saleable != null){
            criteria.andEqualTo("saleable",saleable);
        }
        //默认排序
        example.setOrderByClause("last_update_time DESC");
        // 加入查询
        List<Spu> spus = spuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(spus)){
            throw new YlException(ExceptionEnums.GOODS_NOT_FOUND);
        }
        // 解析分类和品牌的名称
        loadCategoryAndBrandName(spus);

        PageInfo<Spu> pageInfo = new PageInfo<>(spus);
        return new PageResult<>(pageInfo.getTotal(),spus);
    }

    private void loadCategoryAndBrandName(List<Spu> spus) {
        for (Spu spu : spus) {
            // 处理分类名称
            List<String> names = categoryService.queryByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()))
                    .stream().map(Category::getName).collect(Collectors.toList()); // 转化成流 取出name 放入集合
            spu.setCname(StringUtils.join(names,"/"));
            // 处理品牌名称
            String brandName = brandService.queryById(spu.getBrandId()).getName();
            spu.setBname(brandName);
        }
    }
}
