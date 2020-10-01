package AOP.pojo;

import AOP.dao.Rent;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import java.lang.reflect.Method;

/**这个类将被用于自动生成代理类
 * @author 王琪
 * @date 2020/10/1 21:45
 */
public class ProxyInvocationHandler1 implements InvocationHandler {
    /**被代理的接口*/
    private Rent rent;
    public void setRent(Rent rent) {
        this.rent = rent;
    }
    /**生成得到代理类*/
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }
    /**处理代理实例并返回结果*/
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        /*动态代理的本质就是反射机制*/
        seeHouse();
        Object result = method.invoke(rent, objects);
        fare();
        return result;
    }
    /**看房*/
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    /**收中介费*/
    public void fare(){
        System.out.println("中介费");
    }

}
