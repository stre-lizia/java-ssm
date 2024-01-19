package org.xueyinhu.ssm;

/** Spring IOC 容器
 * IOC [ 控制反转 ]
 *  IOC 容器维护着构成应用程序的对象，并负责创建相应对象，反转了控制权。
 * DI [ 依赖注入 ]
 *  DI 是组件之间传递依赖关系的过程中，将依赖关系在容器内部进行处理，实现了对象之间的解耦合
 *  DI 形式：构造函数注入，Setter 方法注入，接口注入
 * --------------------------------------  IOC 容器接口与实现类  -----------------------------------------
 * 接口：
 *  BeanFactory -> SpringIOC 容器标准化超接口，能够管理任何类型的对象
 *  ApplicationContext -> BeanFactory 的完整超集，添加了更多特定于企业的功能
 * 实现类：
 *  ClassPathXmlApplicationContext -> 通过读取类路径下的 XML 格式的配置文件创建容器对象
 *  FileSystemXmlApplicationContext -> 通过文件系统路径读取 XML 格式的配置文件创建容器对象
 *  AnnotationConfigApplicationContext -> 通过读取 Java 配置类创建容器对象
 *  WebApplicationContext -> 专门为 Web 应用准备，基于 Web 环境创建容器对象，并将对象引入存入 ServletContext 域中
 * ----------------------------------------------------------------------------------------------------
 * Spring 框架提供的 IOC 容器配置方式
 *  XML：在文件中定义 Bean 及其依赖关系，作用域等信息
 *  注解：在 Bean 类上使用注解
 *  Java 配置类：通过 Java 类进行配置
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}