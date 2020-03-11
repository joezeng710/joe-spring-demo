package cc.joe.springboot.aspect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cc.joe.springboot.aspect.mapper")
public class SpringbootAspectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAspectApplication.class, args);
    }

}
