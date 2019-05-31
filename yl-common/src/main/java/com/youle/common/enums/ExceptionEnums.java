package com.youle.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空！"),
    CATEGORY_NOT_FOUND(404,"商品分类为空"),
    BRAND_NOT_FOUND(404,"品牌不存在！"),
    BRAND_SAVE_ERROR(500,"新增品牌失败！"),
    UPLOAD_FILE_ERROR(500,"文件上传失败！"),
    INVALID_FILE_TYPE(400,"无效的文件类型！")
    ;
    private int code;
    private String msg;
}
