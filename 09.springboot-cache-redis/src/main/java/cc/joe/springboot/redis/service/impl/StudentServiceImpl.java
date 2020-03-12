package cc.joe.springboot.redis.service.impl;

import cc.joe.springboot.redis.entity.Student;
import cc.joe.springboot.redis.mapper.StudentMapper;
import cc.joe.springboot.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return studentMapper.deleteBysno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return studentMapper.queryStudentBySno(sno);
    }

    @Override
    public int insertSelective(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }
}
