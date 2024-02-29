package org.xueyinhu.ssm.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {
    @PostConstruct
    public void init() {
        System.out.println("Init!");
    }
}
