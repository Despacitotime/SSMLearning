package AOP.pojo;

import AOP.service.UserService;
import AOP.service.impl.UserServiceImpl;

/**
 * @author 王琪
 * @date 2020/10/1 22:00
 */
public class ActiveClient {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userServiceUmpl = new UserServiceImpl();
        //代理角色，不存在
        ProxyInvocationHandler2 pih = new ProxyInvocationHandler2();
        //设置要代理的对象
        pih.setTarget(userServiceUmpl);
        //动态生成代理类
        UserService proxy = (UserService)pih.getProxy();
        proxy.delete();
    }
}
