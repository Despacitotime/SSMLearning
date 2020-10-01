package AOP.pojo;

import AOP.proxy.statics.Proxy;

/**
 * @author 王琪
 * @date 2020/10/1 21:17
 */
public class StaticClient {
    public static void main(String[] args) {
        /*再知道谁租房子的情况下可以直接调用*/
        Host host = new Host();
        host.rent();

        /*不知道房东，找代理，代理会有一些附属操作*/
        Proxy proxy = new Proxy();
        proxy.rent();
    }
}
