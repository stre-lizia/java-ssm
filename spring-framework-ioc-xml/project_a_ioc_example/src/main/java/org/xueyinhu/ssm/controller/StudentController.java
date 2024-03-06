package org.xueyinhu.ssm.controller;

import org.xueyinhu.ssm.service.StudentService;

public class StudentController {

    private StudentService ss;

    public void setSs(StudentService ss) {
        this.ss = ss;
    }

    public void findAll() {
        System.out.println(ss.findAll());
    }
}
