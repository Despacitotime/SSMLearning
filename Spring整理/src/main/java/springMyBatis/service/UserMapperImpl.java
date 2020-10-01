package springMyBatis.service;

import org.mybatis.spring.SqlSessionTemplate;
import springMyBatis.dao.UserMapper;
import springMyBatis.pojo.User;

import java.util.List;

/**
 * @author 王琪
 * @date 2020/10/2 0:03
 */
public class UserMapperImpl implements UserMapper {
    /**方法一：通过SqlSessionTemplate创建
     * 原来所有的操作都使用sqlSession执行，现在统一使用SqlSessionTemplate*/
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }

    public int addUser(User user) {
        return 0;
    }

    public int deleteUser(int id) {
        return 0;
    }
}
