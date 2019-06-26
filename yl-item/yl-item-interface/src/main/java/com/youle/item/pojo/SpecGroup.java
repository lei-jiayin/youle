package com.youle.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品分类规格组
 * @author xw
 * @date 2019/6/5 10:40
 */
@Table(name = "tb_spec_group")
@Data
public class SpecGroup {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long cid;
    private String name;
}
