package com.wq.Dao;
import com.wq.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 王琪
 * @date 2020/9/29 0:41
 */
public interface UserMapper {
    /**查询所有的User
     * @return List<User>*/
    List<User> getUserList();

    /**根据ID查询用户
     * @param id
     * @return User*/
    User getUserById(int id);

    /**insert一个用户
     * @param user
     * @return int*/
    int addUser(User user);

    /**修改一个用户数据
     * @param user
     * @return int*/
    int updateUser(User user);

    /**删除数据
     * @param id
     * @return int*/
    int deleteUser(int id);

    /**map查询，Map是一个键值对
     * 当实体类或数据库中的表、字段或参数过多时，应当考虑使用Map。
     * 好处：无需知道map中有什么，只需要去查对应的字串。
     * 例如使用Map查询User,可以不全部给对象赋值再传数据，因为User对象的数据必须为3个才能创建，而使用Map就可以不这么做。
     * @param map
     * @return User*/
    User getUserById2(Map<String,Object> map);

    /**模糊查询
     * @param name
     * @return List<User>*/
    List<User> getUserLike(String name);

    /**防止SQL注入的模糊查询
     * @param name
     * @return List<User>*/
    List<User> getUserLike2(String name);

    /**分页
     * @param map
     * @return List<User>*/
    List<User> getUserByLimit(Map<String,Integer> map);

    /**RowBounds实现分页
     * @return List<User>*/
    List<User> getUserByRowBounds();

    /**使用注解写SQL语句
     * 使用注解来映射简单语句会使代码显得更加简洁，但对于复杂语句建议使用.xml来配置
     * @param id
     * @return User*/
    @Select("select * from mybatis.user where id=#{id};")
    User selectById(@Param("id")int id);
}
