package AOP.proxy.active;

import AOP.dao.Rent;
import AOP.pojo.Host;
import AOP.pojo.ProxyInvocationHandler1;

/**
 * @author 王琪
 * @date 2020/10/1 21:51
 */
public class ActiveClient {
    public static void main(String[] args) {
        /*真实角色*/
        Host host = new Host();
        /*通过ProxyInvocationHandler生成代理角色*/
        ProxyInvocationHandler1 pih = new ProxyInvocationHandler1();
        /*通过调用程序处理角色来处理我们要调用的接口对象*/
        pih.setRent((Rent)host);

        //动态生成代理类
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
