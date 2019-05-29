package com.youle.common.exception;

import com.youle.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xw
 * @date 2019/5/29 11:10
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class YlException extends RuntimeException {
    private ExceptionEnums exceptionEnums;

}
