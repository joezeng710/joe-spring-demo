package cc.joe.springboot.aspect.service;

import cc.joe.springboot.aspect.entity.Student;

public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
}