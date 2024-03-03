package org.xueyinhu.ssm.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/** \ @Around
 * 其参数中的 proceeding_join_point 与 其他增强方法中的 join_point 相比，多一个执行方法
 * 则其返回的参数则是目标参数的返回值
 */

@Component
@Aspect
public class AroundAdvice {
    @Around("execution(* org..impl.*.*(..))")
    // 必须抛出异常
    public Object transaction(ProceedingJoinPoint jt) {
        final Object[] args = jt.getArgs();
        Object result = null;
        try {
            // @Before
            result = jt.proceed(args);
            // @AfterReturning
        } catch (Throwable e) {
            // @AfterThrowing
            throw new RuntimeException(e);
        } finally {
            // @After
            System.out.println("finally");
        }
        return result;
    }
}
