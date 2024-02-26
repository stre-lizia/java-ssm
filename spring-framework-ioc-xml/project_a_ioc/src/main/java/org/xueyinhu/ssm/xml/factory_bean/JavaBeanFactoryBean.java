package org.xueyinhu.ssm.xml.factory_bean;

import org.springframework.beans.factory.FactoryBean;

public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public JavaBean getObject() throws Exception {
        // 可以写入复杂的构建过程
        JavaBean jb = new JavaBean();
        jb.setName(value);
        return jb;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
