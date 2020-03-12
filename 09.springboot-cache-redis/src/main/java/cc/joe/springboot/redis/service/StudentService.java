package cc.joe.springboot.redis.service;

import cc.joe.springboot.redis.entity.Student;

public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
    int insertSelective(Student student);
    int insert(Student student);
}
