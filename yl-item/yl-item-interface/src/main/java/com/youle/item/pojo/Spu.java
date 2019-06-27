package com.youle.item.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 商品主体表
 * @author xw
 * @date 2019/6/27 9:48
 */
@Data
@Table(name = "tb_spu")
public class Spu {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    // 商标
    private Long brandId;
    // 一级类目
    private Long cid1;
    // 二级类目
    private Long cid2;
    // 三级类目
    private Long cid3;
    // 大标题
    private String title;
    // 小标题
    private String subTitle;
    // 上架下架
    private Boolean saleable;
    // 逻辑删除
    @JsonIgnore
    private Boolean valid;
    private Date createTime;
    @JsonIgnore
    private Date lastUpdateTime;

    @Transient
    private String cname;
    @Transient
    private String bname;

}
