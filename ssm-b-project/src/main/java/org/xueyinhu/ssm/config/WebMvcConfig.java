package org.xueyinhu.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 1. 添加 controller todo @ComponentScan
 * 2. 全局异常处理器
 * 3. handlerMapping handlerAdapter todo @EnableWebMvc
 * 4. 静态资源处理 todo configureDefaultServletHandling
 * 5. jsp 视图解析器的前后缀 todo configureViewResolvers
 * 6. json 转换器
 * 7. 拦截器 todo addInterceptors
 */
@EnableWebMvc
@ComponentScan({"org.xueyinhu.ssm.controller", "org.xueyinhu.ssm.exceptionHandler"})
public class WebMvcConfig implements WebMvcConfigurer {

    // 开启静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // jsp 视图解析器前后缀
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", "jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(new x()).addPathPatterns("").excludePathPatterns("");
    }
}
