package com.youle.common.advice;

import com.youle.common.enums.ExceptionEnums;
import com.youle.common.exception.YlException;
import com.youle.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常拦截通知
 * @author xw
 * @date 2019/5/29 10:53
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(YlException.class)
    public ResponseEntity<ExceptionResult> handleException(YlException e){
        ExceptionEnums em = e.getExceptionEnums();
        return ResponseEntity.status(em.getCode()).body(new ExceptionResult(e.getExceptionEnums()));
    }
}
