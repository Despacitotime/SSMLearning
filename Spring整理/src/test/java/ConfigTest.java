import AOP.service.UserService;
import JavaConfig.config.MyConfig;
import JavaConfig.pojo.UserConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springMyBatis.dao.UserMapper;
import springMyBatis.pojo.User;

import java.io.IOException;
import java.util.List;

/**
 * @author 王琪
 * @date 2020/10/1 21:03
 */
public class ConfigTest {
    @Test
    public void test1(){
        /**如果完全按使用了配置类方式去做，就只能通过AnnotationConfig上下文来获取容器，通过配之类的class对象加载*/
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UserConfig userConfig = context.getBean("getUser", UserConfig.class);
        System.out.println(userConfig.getName());
    }

    /**测试方法一和方法二、方法三都用这个测试方法*/
    @Test
    public void test2(){
        /**动态代理代理的是接口*/
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService user = (UserService) context.getBean("userService");
        user.delete();
    }

    /**测试mybatis和spring的整合*/
    @Test
    public void test3() throws IOException {
        /**方法一：通过implements UserMapper 结合SqlSessionTemplate创建*/
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper1 = context.getBean("userMapper1", UserMapper.class);
        for (User user : userMapper1.selectUser()) {
            System.out.println(user);
        }

        /**方法二：extends SqlSessionDaoSupport implements UserMapper创建*/
        UserMapper userMapper2 = context.getBean("userMapper2", UserMapper.class);
        for (User user : userMapper2.selectUser()) {
            System.out.println(user);
        }
    }

    /**测试错误的声明导致的结果：方法进行到一半会报错，但之前执行的方法可以产生结果，不会回滚*/
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> userList = userMapper.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
