package org.xueyinhu.ssm;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xueyinhu.ssm.xml.factory_bean.JavaBean;
import org.xueyinhu.ssm.xml.ioc.A;
import org.xueyinhu.ssm.xml.ioc.ParameterlessConstruction;
import org.xueyinhu.ssm.xml.action_scope.BeanActionScope1;
import org.xueyinhu.ssm.xml.action_scope.BeanActionScope2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // 创建 ioc 容器
    public void createIoC() {

        // 1. 直接创建容器并且指定配置文件 构造参数（String...配置文件）可以填写多个
        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean.xml");

        // 2. 先创建 ioc 容器，再指定配置文件，再刷新
        // --> 源码的配置过程（创建容器[spring] + 指定配置文件[自己指定]）
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext();
        context2.setConfigLocations("bean.xml");
        context2.refresh();
    }

    // 通过 ioc 容器获取组件 bean
    @Test
    public void getBeanFromIoc() {

        // 获得创建的 ioc 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 1. 通过 bean id 进行获取，返回值类型为 Object 需要强行转换类型，这种方式不推荐使用
        ParameterlessConstruction pc1 = (ParameterlessConstruction) context.getBean("pc");
        // 2. 通过 bean id 进行获取，同时指定 bean 的类型 Class，推荐使用第三种方式
        ParameterlessConstruction pc2 = context.getBean("pc", ParameterlessConstruction.class);
        // 3. 通过 bean 类型进行获取
        // TODO 同一个类型在 ioc 容器中只能有一个 bean，否则会报错 NoUniqueBeanDefinitionException
        ParameterlessConstruction pc3 = context.getBean(ParameterlessConstruction.class);
        // TODO ioc 的配置一定是实现类，但是可以根据接口类型获取值
        A pc4 = context.getBean(A.class);

        // 调用内置方法
        pc1.say();
        pc2.say();
        pc3.say();
        pc4.say();
    }

    // 组件生命周期
    @Test
    public void testLifeCycle() {

        // 创建 ioc 容器，自动对 BeanLifeCycle 组件进行实例化，触发 BeanLifeCycle.init 回调方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");

        // 结束 ioc 容器，自动对 BeanLifeCycle 组件进行销毁，触发 BeanLifeCycle.clear 回调方法
        context.close();
    }

    // 组件作用域
    @Test
    public void testActionScope() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("action_scope.xml");
        // 默认为单实例
        BeanActionScope1 b1 = context.getBean(BeanActionScope1.class);
        BeanActionScope1 b2 = context.getBean(BeanActionScope1.class);
        System.out.println(b1 == b2);
        // 修改为多实例
        BeanActionScope2 b3 = context.getBean(BeanActionScope2.class);
        BeanActionScope2 b4 = context.getBean(BeanActionScope2.class);
        System.out.println(b3 == b4);
    }

    /** FactoryBean 接口是 SpringIoC 容器实例化逻辑的可插拔性点，用于配置复杂的 Bean 对象
     * functions:
     *  T getObject() 返回此工厂创建的对象的实例，该返回值会被存储到 IoC 容器
     *  boolean isSingleton() 返回是否为单例模式
     *  Class<?> getObjectType() 返回 getObject() 方法返回的对象类型，如果不知道类型，则返回 null
     */
    @Test
    public void testFactoryBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factory_bean.xml");
        JavaBean jb = context.getBean(JavaBean.class);
        // todo FactoryBean 工厂也会加入到 ioc 容器，名字：&id
        Object jb_fb = context.getBean("&jb");
        System.out.println("JavaBean: " + jb);
        System.out.println("JavaBeanFactoryBean: " + jb_fb);
        context.close();
    }
}