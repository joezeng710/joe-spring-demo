package cc.joe.springboot.mybatis.service;

import cc.joe.springboot.mybatis.entity.Student;

public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
}