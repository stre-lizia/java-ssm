package org.xueyinhu.ssm.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常发生，会走此类写的 handler
// @ControllerAdvice // 可以返回逻辑视图，转发和重定向
@RestControllerAdvice // @ResponseBody 直接返回 json 字符串
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e) {
        return e.getMessage();
    }
}
