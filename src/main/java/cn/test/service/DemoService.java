package cn.test.service;

import cn.test.entity.Address;
import cn.test.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 2017/12/1.
 */
@Service
public class DemoService {
    @Cacheable(value = "usercache", key = "#id + '_' + #firstName + '_' + #lastName")
    public User findUser(Long id, String firstName, String lastName){
        System.out.println("无缓存的时候调用这里。");
        return new User(id,firstName,lastName);
    }

    @Cacheable(value = "addresscache", key = "#id + '_' + #province + '_' + #city")
    public Address findAddress(Long id, String province, String city){
        System.out.println("无缓存的时候调用这里。");
        return new Address(id,province,city);
    }
}
