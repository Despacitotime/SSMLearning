package IOC.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**该类用于测试在Spring中的对象都会被创建，不管是否使用
 * *@Component等价于：<bean id="testDemoT" class="IOC.pojo.TestDemoT"></bean>
 * *@Component有几个衍生注解：在web开发中，会按照MVC三层架构分层：
 * 	• dao层，习惯用@Repository来标注
 * 	• service层，习惯用@Service来标注
 * 	• controller层，习惯用@Controller来标注
 * 	上述四个注解的功能是一样的，就是代表将某个类注册到Spring中，装配Bean
 * @author 王琪
 * @date 2020/10/1 15:09
 */
@Component
public class TestDemoT {
    /**属性注入
     * *@Value("wq")等价于<property name="name" value="wq"/>
     * 属性注入除了可以放在属性上，也可以放在set方法上*/
    @Value("wq")
    private String name;

    public TestDemoT() {
        System.out.println("TestDemoT被创建了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name"+name);
    }

}
