package org.xueyinhu.ssm;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.xueyinhu.ssm.components.Student;
import org.xueyinhu.ssm.components.Teacher;

/** 注解 配置 IOC 容器
 * -------------------------------- 注解类型（功能上没有任何区别） ------------------------------------------
 * \@Component 用于描述 Bean，泛化概念，标识容器中的一个组件
 * \@Repository 用于数据访问层（Dao）
 * \@Service 用于业务层（Service）
 * \@Controller 用于控制层（Controller）
 */
@Component("c_main") // id=“c_main” class="Main"
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // LifeCycle
        Student student1 = context.getBean(Student.class);
        student1.saySelf();

        // 被排除
        // Teacher teacher = context.getBean(Teacher.class);

        // Scope
        Student student2 = context.getBean(Student.class);
        System.out.println(student1 == student2);

        // DI
        student1.sayChild();

        context.close();
    }
}
