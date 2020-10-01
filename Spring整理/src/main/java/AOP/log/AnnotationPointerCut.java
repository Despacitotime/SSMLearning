package AOP.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**使用注解实现AOP
 * *@Aspect标注该类为切面
 * @author 王琪
 * @date 2020/10/1 23:20
 */
@Aspect
public class AnnotationPointerCut {
    /**括号内为切入点,*(..)表无论多少个参数*/
    @Before("execution(* AOP.service.impl.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("==============方法执行前===============");
    }
    /**在环绕增强中可以给定一个参数，代表我们需要获取处理切入的点*/
    @Around("execution(* AOP.service.impl.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint p) throws Throwable {
        /**---在before之前执行的部分---------------------------------------*/
        System.out.println("环绕前");
        //获得签名
        Signature signature = p.getSignature();
        System.out.println("signature"+signature);

        /**----在after之后执行的部分，调用的方法之后执行----------------------*/
        /*执行的方法*/
        Object proceed = p.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }

}
