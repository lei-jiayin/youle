package com.youle.item.mapper;

import com.youle.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {

    @Insert("insert into tb_category_brand(category_id,brand_id) values(#{categoryId},#{brandId})")
    int inserCategoryBrand(@Param("categoryId")Long categoryId,@Param("brandId")Long brandId);
}
