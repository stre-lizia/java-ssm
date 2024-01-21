package org.xueyinhu.ssm;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xueyinhu.ssm.xml.A;
import org.xueyinhu.ssm.xml.ParameterlessConstruction;

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
}