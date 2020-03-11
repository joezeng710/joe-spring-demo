package cc.joe.springboot.aspect;

import cc.joe.springboot.aspect.entity.Student;
import cc.joe.springboot.aspect.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootAspectApplication.class)
class SpringbootRedisCacheApplicationTests {
    @Autowired
    private StudentService studentService;

    @Test
    public void test() throws Exception {
        Student student1 = studentService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生的姓名为：" + student1.getName());
        Student student2 = studentService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生的姓名为：" + student2.getName());
    }

    @Test
    void contextLoads() {
    }

}
