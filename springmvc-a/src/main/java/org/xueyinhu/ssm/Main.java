package org.xueyinhu.ssm;

public class Main {

    /** SpringMVC
     * 涉及组件：
     *  1. DispatcherServlet：使用 web.xml 配置，是整个流程处理的核心，所有请求都经过它的处理和分发
     *  2. HandlerMapping：需要进行 IOC 配置并加入 IOC 容器生效，内部缓存 handler (controller 方法) 和 handler 访问路径，
     *      被 DispatcherServlet 调用，用于查找路径对应的 handler
     *  3. HandlerAdapter：需要进行 IOC 配置并加入 IOC 容器生效，可以处理请求参数和处理响应数据，
     *      每次 DispatcherServlet 都是通过 handlerAdapter 间接调用 handler，作为适配器。
     *  4. Handler：处理器，是 Controller 类内部方法的简称，用来接收参数，调用业务，返回响应结果。
     *  5. ViewResolver：需要进行 IOC 配置并加入 IOC 容器生效，简化模板视图页面查找，一般前后端分离项目用不到这个组件。
     */

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}