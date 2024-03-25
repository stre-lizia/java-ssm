package org.xueyinhu.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.xueyinhu.ssm.interceptor.Process01Interceptor;

@Configuration
@ComponentScan({"org.xueyinhu.ssm.controller", "org.xueyinhu.ssm.error"})
@EnableWebMvc // handlerMapping handlerAdapter json转换器
public class MvcConfig implements WebMvcConfigurer {

    // 视图解析器，指定前后缀
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 开启 静态资源 查找
        // todo dispatcherServlet -> handlerMapping -> no? -> 静态资源
        configurer.enable();
    }

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置方案1：全部拦截
        // registry.addInterceptor(new Process01Interceptor());

        // 配置方案2：部分拦截
        registry.addInterceptor(new Process01Interceptor()).addPathPatterns("/user/**");

        // 配置方案3：排除拦截
        registry.addInterceptor(new Process01Interceptor()).excludePathPatterns("/data/**");
    }
}
