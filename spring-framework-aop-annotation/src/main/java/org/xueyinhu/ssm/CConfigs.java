package org.xueyinhu.ssm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.xueyinhu.ssm.sevice.impl.CalculatorPureImpl;

@Configuration
@ComponentScan(value = "org.xueyinhu.ssm")
@EnableAspectJAutoProxy
// TODO 在配置文件中，<aop:aspectj-autoproxy/> 代表支持 aspect 注解
public class CConfigs {
}
