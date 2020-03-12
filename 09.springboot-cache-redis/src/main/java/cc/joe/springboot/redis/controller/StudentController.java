package cc.joe.springboot.redis.controller;

import cc.joe.springboot.redis.entity.Student;
import cc.joe.springboot.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/querystudent")
    public Student query(String sno) {
        return studentService.queryStudentBySno(sno);
    }
}
