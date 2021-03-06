package cn.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by jt on 2017/11/22.
 */
public class TestShiro {
    public static void main(String args[]){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini") ;
        SecurityManager securityManager = factory.getInstance() ;
        SecurityUtils.setSecurityManager(securityManager) ;
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","1231") ;
        try {
            subject.login(usernamePasswordToken) ;
        }catch (IncorrectCredentialsException e){
            System.out.print("密码错误");
        }catch (UnknownAccountException e){
            System.out.println("账号不存在");
        }

        System.out.print(subject.getPrincipal());
    }
}
