package org.xueyinhu.ssm;

public class Main {

    /** ssm
     * Question:
     *  1. ssm 需要两个容器（web 容器和 root 容器），这样的做法有如下好处：
     *      1> 分离关注点，通过初始化两个容器，可以将各个层次的关注点进行分离。
     *      2> 解耦合，每个层次组件分离装配不同的 IOC 容器，提高了代码的可维护性与可测试性。
     *      3> 灵活配置，可以为两个容器提供不同的配置。
     *  2. 两个容器分别对应三层架构的哪一层：
     *      web 容器 -> web 相关组件（controller，springmvc 核心组件）
     *      root 容器 -> 业务和持久层相关组件（service，aop，tx，dataSource，mybatis，mapper 等）
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}