package org.xueyinhu.ssm;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class Main implements WebApplicationInitializer {
    /** 接口 WebApplicationInitializer
     * 当 Web 项目启动时，就会自动调用该接口的 onStartup 方法
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}