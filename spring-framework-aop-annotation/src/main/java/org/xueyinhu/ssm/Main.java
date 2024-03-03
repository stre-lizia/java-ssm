package org.xueyinhu.ssm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xueyinhu.ssm.sevice.Calculator;
import org.xueyinhu.ssm.sevice.impl.CalculatorPureImpl;

import java.util.stream.Stream;

/** AOP 面向切片编程是一种范式，通过将通用的横切关注点（日志、事务、权限控制等）与业务逻辑分离，使得代码更加清晰、简洁、易于维护。
 * 场景：
 *  日志记录 在方法执行前后或者抛出异常时进行日志的记录
 *  事务处理 在方法前开启事务，在执行完成之后提交或者回滚事务
 *  安全控制 在方法执行前进行权限的判断
 *  性能监控 在方法执行前记录时间戳，在方法执行完毕后计算方法执行时间并输出到日志中
 *  异常处理 在方法执行出现异常时进行处理
 *  缓存控制 在方法执行前查找对应的缓存数据，否则执行完成后将返回值存入缓存之中
 *  动态代理 可以代理某个类的所有方法，用于实现各种功能
 * 通知织入位置：
 *  前置通知、返回通知、异常通知，后置通知、环绕通知
 * ---
 * Spring 基于注解的 AOP
 *  AspectJ 注解层 -> 具体实现层（有接口使用动态代理，无接口使用 cglib）
 */
public class Main {


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(CConfigs.class);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        Stream.of(beanDefinitionNames).forEach(System.out::println);
        Calculator calculator = context.getBean(Calculator.class);
        System.out.println(calculator.add(2, 3));
    }
}
