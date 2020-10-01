package IOC.UserService.impl;

import IOC.UserService.UserService;
import IOC.dao.UserDao;
import IOC.dao.UserDaoImpl;

/**
 * @author xxx
 * @date 2020/10/1 10:07
 */
public class UserServiceImpl implements UserService {
    /**根据环境代码提出问题，当需求改变，加入了新的功能，由于UserService的语句：
     private UserDao userDao = new UserDaoImpl();
     定死了，使得每一次需求变更都会造成源代码的改变，在大量代码的情况下，很难修改。*/
    private UserDao userDao;

    /**解决方式，使用set动态注入
     * 优点：使用set之前，程序是主动创建对象，控制权在程序员手上；使用set注入后，程序不在具有主动性，而是变成了被动的接收对象。
     * 这就是控制反转的思想，IOC的原型。*/
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
