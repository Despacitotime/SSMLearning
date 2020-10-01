package springMyBatis.dao;

import springMyBatis.pojo.User;

import java.util.List;

/**
 * @author 王琪
 * @date 2020/10/2 0:01
 */
public interface UserMapper {
    /**查询所有用户
     * @return List<User>*/
    List<User> selectUser();

    /**添加一个用户
     * @param user
     * @return int*/
    int addUser(User user);

    /**删除一个用户
     * @param id
     * @return int*/
    int deleteUser(int id);

}
