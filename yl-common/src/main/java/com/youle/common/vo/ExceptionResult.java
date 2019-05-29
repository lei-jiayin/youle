package com.youle.common.vo;

import com.youle.common.enums.ExceptionEnums;
import lombok.Data;

/**
 * @author xw
 * @date 2019/5/29 11:23
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums e) {
        this.status = e.getCode();
        this.message = e.getMsg();
        this.timestamp = System.currentTimeMillis();
    }

}
