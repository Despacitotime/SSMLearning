package AOP.pojo;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author 王琪
 * @date 2020/10/1 21:57
 */
public class ProxyInvocationHandler2 implements InvocationHandler {
    /**被代理的接口*/
    private Object target;
    public void setTarget(Object target) {
        this.target = target;
    }
    /**生成得到代理类*/
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    /**处理代理实例并返回结果*/
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        /*动态代理的本质就是反射机制*/
        log(method.getName());
        Object result = method.invoke(target, objects);
        return result;
    }
    /**添加日志功能*/
    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
