package cc.joe.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cc.joe.springboot.mybatis.mapper")
public class SpringbootMybatisGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisGeneratorApplication.class, args);
    }

}
