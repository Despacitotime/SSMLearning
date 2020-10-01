package IOC.dao;

import IOC.dao.UserDao;

/**
 * @author 王琪
 * @date 2020/10/1 10:01
 */
public class UserDaoImpl implements UserDao {
    public void getUser(){
        System.out.println("默认获取用户数据");
    }
}
