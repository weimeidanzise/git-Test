import com.itheima.dao.*;
import com.itheima.domain.User;
import com.itheima.factory.BeanFactory;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class TestDemo11 {
    public static void main(String[] args) {

        //调用服务层：通过key获取Map容器的对象（反射创建的接口类对象）
        UserService userService = (UserService) BeanFactory.getBean("userService");
        userService.findAll();
        UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
        System.out.println(userDao);
    }

    @Test
    public void buy() {
        BuyDao buyDao = (BuyDao) BeanFactory.getBean("buyDao");
        buyDao.buy();
    }

    @Test
    public void Test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springCore.xml");
        User u1=(User)ac.getBean("u");

        User u2=ac.getBean("u",User.class);

        User u3=ac.getBean(User.class);

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }
    @Test
    public void Test2(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("springCore.xml");
        User u1=(User)ac.getBean("list");
        System.out.println(u1);

    }
}

