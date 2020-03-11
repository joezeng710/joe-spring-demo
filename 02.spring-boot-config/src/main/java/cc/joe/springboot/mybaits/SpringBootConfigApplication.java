package cc.joe.springboot.mybaits;

import cc.joe.springboot.mybaits.properties.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootConfigApplication {

    @Autowired
    private BlogProperties blogProperties;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }

    @GetMapping("/")
    public String foo() {
        return "foo";
    }

    @GetMapping("/blog")
    public String blog() {
        return blogProperties.getName() + blogProperties.getTitle() + "3";
    }
}
