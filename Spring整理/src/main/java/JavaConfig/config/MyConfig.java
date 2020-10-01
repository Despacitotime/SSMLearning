package JavaConfig.config;

import JavaConfig.pojo.UserConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * *@Configuration代表这是一个配置类，就和我们之前看到的beans.xml一样
 * *@Configuration也会被Spring容器托管，注册倒容器中，因为他本来就是一个@Component
 * *@ComponentScan("JavaConfig.pojo")可以和beans.xml中一样设置扫描包
 * @author 王琪
 * @date 2020/10/1 20:59
 */

@Configuration
@ComponentScan("JavaConfig.pojo")
public class MyConfig {
    /**注册一个Bean，就相当于之前的bean标签,方法名相当于id，返回值相当于class
     * 此处返回的就是要注入到bean中的对象*/
    @Bean
    public UserConfig getUser(){
        return new UserConfig();
    }

}
