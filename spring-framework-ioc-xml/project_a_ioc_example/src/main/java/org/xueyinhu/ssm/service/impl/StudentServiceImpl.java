package org.xueyinhu.ssm.sevice.impl;

import org.xueyinhu.ssm.Student;
import org.xueyinhu.ssm.dao.StudentDao;
import org.xueyinhu.ssm.sevice.StudentService;

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
