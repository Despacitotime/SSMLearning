package AOP.pojo;

import AOP.proxy.statics.UserServiceProxy;
import AOP.service.impl.UserServiceImpl;

/**
 * @author 王琪
 * @date 2020/10/1 21:29
 */
public class UserServiceClient {
    public static void main(String[] args) {
        /*普通调用*/
        UserServiceImpl user = new UserServiceImpl();
        user.add();

        /*通过代理*/
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserServiceImpl(user);
        userServiceProxy.add();
    }
}
