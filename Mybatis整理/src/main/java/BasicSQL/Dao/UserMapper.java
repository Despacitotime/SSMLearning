package BasicSQL.Dao;
import BasicSQL.pojo.User;
import org.apache.ibatis.annotations.*;

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
     * @Param()使用的注意事项：
     * 基本类型的参数或者String类型的参数需要加上，引用类型不需要;
     * 如果只有一个基本类型，可以不加（但建议除了引用都加上）,在SQL中引用的（即#{}中的内容）就是@Param()中的内容。
     * @param id
     * @return User*/
    @Select("select * from mybatis.user where id=#{id};")
    User selectById(@Param("id")int id);

    /**注解版查询全部用户
     * @return List<User>*/
    @Select("select * from user")
    List<User> getUsers();

    /**注解版根据id和name进行查询
     * 此处只有两个参数，而创建一个User对象要三个，和Map的方法一致，下为注解的方法
     * 方法有多个参数时所有参数前必须加上@Param注解，id=#{id}中#{}中的参数对应@Param("id")中的id
     * @param id
     * @param name
     * @return User*/
    @Select("select * from user where id=#{id} and name=#{name} ")
    User getUserByIds(@Param("id") int id,@Param("name") String name);

    /**注解版添加用户
     * values (#{id},#{name},#{password})语句中的属性名必须和实体类中的一致
     * @param user
     * @return int*/
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser2(User user);

    /**注解版修改用户
     * @param user
     * @return int*/
    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser2(User user);

    /**注解版删除用户
     * @param id
     * @return int*/
    @Delete("delete from user where id=#{id}")
    int deleteUser2(@Param("id")int id);
}
