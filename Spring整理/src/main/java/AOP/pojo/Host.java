package AOP.pojo;

import AOP.dao.Rent;

/**
 * @author 王琪
 * @date 2020/10/1 21:16
 */
public class Host implements Rent {
    public void rent() {
        System.out.println("房东出租房子！");
    }
}
