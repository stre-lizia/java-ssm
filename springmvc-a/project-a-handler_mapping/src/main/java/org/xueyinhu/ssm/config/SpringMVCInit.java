package org.xueyinhu.ssm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 继承该类，可以被web项目加载，会初始化 IOC 容器，会设置 dispatcherServlet 的地址
public class SpringMVCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 设置该 web 项目的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{TMVCConfig.class};
    }

    // 配置 springmvc 内部自带 servlet 的访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
