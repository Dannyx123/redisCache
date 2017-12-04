package cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt on 2017/11/22.
 */
@SpringBootApplication
@RestController
public class StartSpringBoot {
    public static void main(String args[]){
        SpringApplication.run(StartSpringBoot.class,args) ;
    }

    @RequestMapping("/")
    public String hello(){
        return "hello world !" ;
    }
}
