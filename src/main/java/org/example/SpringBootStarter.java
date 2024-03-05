package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "org.example.mapper")
public class SpringBootStarter
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
