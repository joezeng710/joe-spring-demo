package cc.joe.springboot.mybaits.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = {"classpath:custom.properties"})
@ConfigurationProperties(prefix = "joe.blog")
public class BlogProperties {

    private String name;
    private String title;
}
