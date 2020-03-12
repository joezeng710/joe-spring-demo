package cc.joe.springboot.redis.service;

import cc.joe.springboot.redis.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "student")
public interface StudentService {
    int add(Student student);
    @CachePut(key = "#p0.sno")
    Student update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    int deleteBysno(String sno);

    @Cacheable(key = "#p0")
    Student queryStudentBySno(String sno);

    int insertSelective(Student student);
    int insert(Student student);
}
