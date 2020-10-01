package AOP.service.impl;

import AOP.service.UserService;

/**
 * @author 王琪
 * @date 2020/10/1 21:25
 */
public class UserServiceImpl implements UserService {
    public void add(){
        System.out.println("增加");
    }
    public void delete(){
        System.out.println("删除");
    }
    public void update(){
        System.out.println("更新");
    }
    public void query(){
        System.out.println("查询");
    }
}
