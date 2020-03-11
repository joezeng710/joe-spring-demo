package cc.joe.springboot.mybatis.mapper;

import cc.joe.springboot.mybatis.entity.Student;

public interface StudentMapper {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
    int insertSelective(Student student);
    int insert(Student student);
}
