package cc.joe.springboot.aspect.mapper;

import cc.joe.springboot.aspect.entity.Student;

public interface StudentMapper {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
}

