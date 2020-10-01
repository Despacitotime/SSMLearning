package AOP.proxy.statics;

import AOP.service.UserService;
import AOP.service.impl.UserServiceImpl;

/**
 * @author 王琪
 * @date 2020/10/1 21:26
 */
public class UserServiceProxy implements UserService {
    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public void add() {
        log("add");
        userServiceImpl.add();
    }

    public void delete() {
        log("delete");
        userServiceImpl.delete();
    }

    public void update() {
        log("update");
        userServiceImpl.update();
    }

    public void query() {
        log("query");
        userServiceImpl.query();
    }

    public void log(String message){
        System.out.println("使用了"+message+"方法");
    }
}
