package org.xueyinhu.ssm.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 默认为单例模式，现在是多例
@Component // id="student" class="Student"
public class Student {

    // Value 注解可用于赋值操作，常用于外部文件的数据赋值，可以用 "${key:value}" 的方式引入（可以设置默认值）
    @Value("19")
    private int age;
    @Value("${data.name:none}")
    private String data_name;

    @Autowired // property 该注解也可以加在 构造函数 或 setter 函数上
    @Qualifier(value = "child")
    // 若有多个对应类型，默认会根据属性名进行匹配，也可以使用 Qualifier 注解来指定（不可以单独使用）
    // 优化方案：@Resource(name = "child") 默认按照属性名进行指定
    // @Autowired(required = false) 可以不存在对应类型，为空，不推荐使用
    private Child child;

    // lifecycle
    @PostConstruct
    public void init() {
        System.out.println("init!");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("destroy!");
    }

    public void saySelf() {
        System.out.println("This is a Student Instance. And the data name is " + data_name + ".");
    }
    public void sayChild() {
        child.sayChild();
    }
}
