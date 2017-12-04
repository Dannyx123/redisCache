package cn.test.controller;

import cn.test.entity.Address;
import cn.test.entity.User;
import cn.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt on 2017/12/1.
 */
@RestController
public class DemoEndpoint {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String putCache(){
        demoService.findUser(1L, "zhang", "san");
        demoService.findAddress(2L, "jx", "gz");
        System.out.println("if it not print '无缓存的时候调用。' ,it means the test is success.");
        return "OK";
    }
    @RequestMapping(value = "/test2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testCache(){
        User user = demoService.findUser(1L, "zhang", "san");
        Address address =demoService.findAddress(2L, "jx", "gz");
        System.out.println("it not excute query");
        System.out.println("user:"+"/"+user.getFirstName()+"/"+user.getLastName());
        System.out.println("address:"+"/"+address.getProvince()+"/"+address.getCity());
        return "OK";
    }
}

