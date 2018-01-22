package cn.roye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. @RestController is a stereotype annotation that combines @ResponseBody and @Controller
 * 2. 这个类必须要放到一个package里面。
 */
@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @GetMapping("/hello")
    public String hello(){
        return "public String hello";
    }
}
