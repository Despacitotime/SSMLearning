package JavaConfig.pojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * *@Component的意思就是说这个类被Spring接管，注册到了容器中
 * @author 王琪
 * @date 2020/10/1 20:54
 */

@Component
public class UserConfig {
    private String name;
    @Value("wq")
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }

}
