package springMyBatis.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import springMyBatis.dao.UserMapper;
import springMyBatis.pojo.User;

import java.util.List;

/**
 * @author 王琪
 * @date 2020/10/2 0:09
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
//    public List<User> selectUser() {
//        return getSqlSession().getMapper(UserMapper.class).selectUser();
//    }

    public List<User> selectUser() {
        User user = new User(5, "5号", "32142");
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.addUser(user);
        //在一个方法中刻意调用错误的配置SQL语句，方法中途报错
        mapper.deleteUser(11);
        return mapper.selectUser();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }

}
