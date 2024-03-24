package org.xueyinhu.ssm.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

    /** 返回视图
     * 1. 方法的返回值是字符串类型
     * 2. 不能使用 @ResponseBody 注解，不走视图解析器
     * 3. 返回值写对应的视图名称
     */
    @GetMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "Hello");
        return "index";
    }

    /** 转发
     * 1. 方法的返回值使用字符串
     * 2. 不使用 @ResponseBody 注解
     * 3. 返回的字符串格式：forward:/转发地址
     */
    @GetMapping("forward")
    public String for_word() {
        return "forward:/jsp/index";
    }

    /** 重定向
     * 3. redirect:/重定向地址
     * ---
     * todo 需要注意的是: 【不使用 SpringMvc】
     *  转发默认是同一项目下的资源跳转，可以忽略 ApplicationContext
     *  重定向可以是项目内或项目外，不可忽略 ApplicationContext，SpringMvc 会默认帮忙加全路径
     *      若重定向到项目外的地址，直接返回网址
     */
    @GetMapping("redirect/baidu")
    public String redirectBaidu() {
        return "redirect:http://www.baidu.com";
    }
}
