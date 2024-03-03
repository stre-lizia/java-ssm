package org.xueyinhu.ssm.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/** 增强类，存储增强代码
 * 1. 定义方法，即增强代码
 * 2. 使用注解指定对应的位置
 * 3. 配置切点表达式选中方法
 * 4. 切面和IOC的设置
 * 5. 开启aspect注解的支持
 * ---
 * 存储方法的数量取决于插入的位置
 *  前置 @Before
 *  后置 @AfterReturning
 *  异常 @AfterThrowing
 *  最后 @After
 *  环绕 @Around
 *      环绕 可以自定义位置 包括以上四个位置
 * ---
 *   try {
 *       前置
 *       目标方法
 *       后置
 *   } catch() {
 *       异常
 *   } finally {
 *       最后
 *   }
 * ---
 * 切点表达式
 *  固定语法 execution(
 *      访问修饰符 方法的返回参数类型 包的位置.类的名称.方法名(参数列表)
 *  )
 *  若 访问修饰符 与 方法的返回参数类型 都不考虑，则用一个 * 代替
 *  若不使用包的全路径，则可以使用 * 单层模糊，用 .. 则多层模糊，开头不能使用 .. 模糊
 *  若考虑包下的多个不同名称的类，则可以使用 * 来全选，也可以是用类似于 *Impl 来部分模糊
 *  方法名与类名类似
 *  若方法参数不考虑，则直接使用 ..，若部分模糊，例如 String.. 或 ..int 或 string..int
 * ---
 * 切点表达式的提取和复用
 *  1. 在当前类中提取，定义一个加 @PointCut 的空方法，存储切点表达式，之后使用函数名称就能引用，不建议
 *  2. 建议建立一个用于存储切点表达式的类，便于管理与维护
 * ---
 * 补全注解：
 *  \ @Component 加入 IOC 容器
 *  \ @Aspect 配置切点表达式（选中插入的方法，切点）
 * ---
 * TODO 在配置文件或者配置类中开启 aspect
 * TODO @EnableAspectJAutoProxy
 * TODO 在配置文件中，<aop:aspect-autoproxy/> 代表支持 aspect 注解
 */

@Component
@Aspect
public class LogAdvice {

    @Pointcut("execution(* org.xueyinhu.ssm.sevice.impl.*.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void start() {
        System.out.println("Start!");
    }

    @After("execution(* org.xueyinhu.ssm.sevice.impl.*.*(..))")
    public void after() {
        System.out.println("After!");
    }

    @AfterThrowing("execution(* org.xueyinhu.ssm.sevice.impl.*.*(..))")
    public void error() {
        System.out.println("Error!");
    }
}
