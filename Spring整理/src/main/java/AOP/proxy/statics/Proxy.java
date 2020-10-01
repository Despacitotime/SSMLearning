package AOP.proxy.statics;

import AOP.pojo.Host;

/**代理实体类
 * @author 王琪
 * @date 2020/10/1 21:18
 */
public class Proxy {
    private Host host;
    public Proxy() {
    }
    public Proxy(Host host) {
        this.host = host;
    }
    public void rent(){
        seeHouse();
        host.rent();
        signTale();
        fare();
    }

    /*看房*/
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    /*签合同*/
    public void signTale(){
        System.out.println("签合同");
    }
    /*收中介费*/
    public void fare(){
        System.out.println("中介费");
    }
}
