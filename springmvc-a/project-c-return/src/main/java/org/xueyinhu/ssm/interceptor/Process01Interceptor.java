package org.xueyinhu.ssm.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Process01Interceptor implements HandlerInterceptor {

    /** 在执行 handler 之前调用拦截方法
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 调用的 handler
     * @return true=放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    /** 在执行 handler 之后调用拦截方法
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 调用的 handler
     * @param modelAndView 返回的视图和共享域数据对象
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /** 整体处理完毕后
     * @param request 请求
     * @param response 响应
     * @param handler handler
     * @param ex handler 报错的异常对象
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
