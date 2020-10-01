import IOC.UserService.impl.UserServiceImpl;
import IOC.dao.UserDaoImpl;
import IOC.pojo.People;
import IOC.pojo.TestDemo;
import IOC.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xxx
 * @date 2020/10/1 10:08
 */
public class IocTest {
    /**测试普通方法*/
    @Test
    public void test1(){
        /*用户实际调用的是业务层，不用解除Dao层*/
        UserServiceImpl userService = new UserServiceImpl();
        userService.getUser();
    }

    /**测试set注入*/
    @Test
    public void test2(){
        /*用户实际调用的是业务层，不用解除Dao层*/
        UserServiceImpl userService = new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
        userService.getUser();
    }

    /**第一个Spring程序,测试类TestDemo
     * spring最重要的一点就是需要类中必须得有set方法*/
    @Test
    public void test3(){
        /*获取Spring的上下文对象，所有的对象通过xml写到spring中，需要使用则直接去里面取*/
        /**在配置文件加载的时候，容器中管理爹对象就已经初始化了，所以其中所有的对象都会被创建*/
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*取Hello对象*/
        TestDemo testDemo = (TestDemo) context.getBean("testDemo");
        System.out.println(testDemo.toString());
    }

    /**测试别名*/
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
        User user2 = (User) context.getBean("dfgdf");
        System.out.println(user2);
    }

    /**测试p命名空间*/
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }

    /**测试c命名空间*/
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        TestDemo testDemo = (TestDemo) context.getBean("testDemo");
        System.out.println(testDemo);
    }

    /**测试自动装配的环境（普通注入方式）*/
    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people",People.class);
        people.getCat().shout();
        people.getDog().shout();
    }

    /**注解方式的自动装配*/
    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people",People.class);
        people.getCat().shout();
        people.getDog().shout();
    }

    /**测试注解注入*/
    @Test
    public void test9(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestDemo testDemo = (TestDemo) context.getBean("testDemo", TestDemo.class);
        System.out.println(testDemo);
    }

    /**测试属性注入*/
    @Test
    public void test10(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestDemo testDemo = (TestDemo) context.getBean("testDemo", TestDemo.class);
        System.out.println(testDemo);
    }

}
