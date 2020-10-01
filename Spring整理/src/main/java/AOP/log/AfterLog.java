package AOP.log;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;
/**
 * @author 王琪
 * @date 2020/10/1 22:40
 */
public class AfterLog implements AfterReturningAdvice {
    /**o为返回值*/
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName());
    }
}
