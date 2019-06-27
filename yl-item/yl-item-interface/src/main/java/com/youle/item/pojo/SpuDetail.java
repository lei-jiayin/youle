package com.youle.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xw
 * @date 2019/6/27 9:56
 */
@Table(name = "t_spu_detail")
@Data
public class SpuDetail {

    @Id
    private Long spuId;
    private String description;
    private String specialSpec;
    private String genericSpec;
    private String packingList;
    private String afterService;
}
