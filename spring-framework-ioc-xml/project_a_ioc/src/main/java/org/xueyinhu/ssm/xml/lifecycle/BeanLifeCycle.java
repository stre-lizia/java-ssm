package org.xueyinhu.ssm.xml.lifecycle;

public class BeanLifeCycle {

    /** 初始化方法
     * 必须是 public，返回值是 void，必须无参数
     */
    public void init() {
        System.out.println("BeanLifeCycle.init");
    }

    // 销毁方法
    public void clear() {
        System.out.println("BeanLifeCycle.clear");
    }
}
