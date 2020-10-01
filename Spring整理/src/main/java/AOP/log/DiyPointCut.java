package AOP.log;

/**自定义切入点类
 * @author 王琪
 * @date 2020/10/1 23:13
 */
public class DiyPointCut {
    public void before(){
        System.out.println("===============方法执行前===============");
    }

    public void after(){
        System.out.println("===============方法执行后===============");
    }
}
