package com.threeeggpie.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@SpringBootApplication 注解隐含了 @ComponentScan 注解，用于扫描 Spring 组件。默认情况下，它只会扫描标记为 Spring 组件的类（如 @Component、@Service、@Controller、@Repository 等）。而 @Mapper 并不是这些注解之一，因此它不会被自动扫描。
@MapperScan("com.threeeggpie.template.dao") //把包下的所有类都注册为Mapper，这个包下的Mapper不用加@Mapper
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

}
