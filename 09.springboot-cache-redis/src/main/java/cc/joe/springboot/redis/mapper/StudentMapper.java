package cc.joe.springboot.redis.mapper;

import cc.joe.springboot.redis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
    int insertSelective(Student student);
    int insert(Student student);
}
