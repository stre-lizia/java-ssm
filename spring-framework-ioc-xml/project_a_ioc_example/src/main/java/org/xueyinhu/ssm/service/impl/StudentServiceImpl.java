package org.xueyinhu.ssm.service.impl;

import org.xueyinhu.ssm.Student;
import org.xueyinhu.ssm.dao.StudentDao;
import org.xueyinhu.ssm.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao sd;

    public void setSd(StudentDao sd) {
        this.sd = sd;
    }

    @Override
    public List<Student> findAll() {
        return sd.queryAll();
    }
}
