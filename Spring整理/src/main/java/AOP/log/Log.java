package AOP.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author 王琪
 * @date 2020/10/1 22:41
 */
public class Log implements MethodBeforeAdvice {
    /**参数解释：
     * method：要执行的目标对象的方法
     * objects：参数
     * o：目标对象*/
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+"的"+method.getName()+"被执行了"+"方法，返回结果为："+o);
    }
}
