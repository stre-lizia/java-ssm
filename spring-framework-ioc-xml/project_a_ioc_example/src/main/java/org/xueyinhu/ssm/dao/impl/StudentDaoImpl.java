package org.xueyinhu.ssm.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.xueyinhu.ssm.Student;
import org.xueyinhu.ssm.dao.StudentDao;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public List<Student> queryAll() {
        String sql = "select id, name, gender, age, class as classes from students;";
        return jt.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
