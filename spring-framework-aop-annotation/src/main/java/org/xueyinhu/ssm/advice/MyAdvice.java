package org.xueyinhu.ssm.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/** 增强方法中获得目标方法信息
 * 1. 全部增强方法中，获得目标方法的信息（方法名，参数，访问修饰符，所属的类别信息）
 *  在形参列表加入 joinPoint 其中就包含切入点的信息
 * 2. AfterReturning 获得返回值
 *  在形参里面加入一个 Object 类型的值，然后在注解进行指定
 * 3. AfterThrowing 获得异常值
 *  在形参里面加入一个 Throwable 类型的值，然后在注解进行指定
 */
@Component
@Aspect
public class MyAdvice {
    @Before("execution(* org..impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // 所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers(); // 修饰符
        String m = Modifier.toString(modifiers); // 转化为对应的字符串
        String name = joinPoint.getSignature().getName();
        // 获取参数列表
        Object[] args = joinPoint.getArgs();

        System.out.print(simpleName + " " + name + " ");
        System.out.println(Arrays.toString(args));
    }

    @AfterReturning(value = "execution(* org..impl.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
    }

    @After("execution(* org..impl.*.*(..))")
    public void after() {
    }

    @AfterThrowing(value = "execution(* org..impl.*.*(..))", throwing = "throwable")
    public void afterThrowing(Throwable throwable) {
    }
}
