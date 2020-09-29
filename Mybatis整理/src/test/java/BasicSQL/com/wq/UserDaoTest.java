package BasicSQL.com.wq;
import BasicSQL.com.wq.Dao.UserMapper;
import BasicSQL.com.wq.pojo.User;
import BasicSQL.com.wq.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
/**注意点：可能IDE自动导错了包导致出错 import java.util.logging.Logger;
 * 应该导入apache的Logger包*/
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    /**读取配置文件*/
    static Logger logger = Logger.getLogger("com.wq.UserDaoTest");

    /**查询所有的User*/
    @Test
    public void test(){
        SqlSession sqlSession = null;
        try{
            //获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //调用getUserList()方法的的两种方式：
            //1.getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for(User user : userList){
                System.out.println(user);
            }
            //2.根据方法的返回值类型来选择，如返回为List，就有selectList
            /*List<User> object = sqlSession.selectList("com.wq.Dao.UserMapper.getUserList");//返回object，强转为User*/
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
//            sqlSession.close();
        }
    }

    /**根据ID查询用户*/
    @Test
    public void test1(){
        //获取SqlSession对象
        SqlSession sqlSession = null;

        try{
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**insert一个用户*/
    @Test
    public void test2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(5, "5号", "12345");
            int i = userMapper.addUser(user);
            if (i > 0) {
                System.out.println("插入成功！");
            }
            /**增删改需要提交事务，不然就会出现虽然正常进行了插入，但是数据没有更新的情况
             * 如果在工具类中已经设置了主动提交，以下语句可以省略*/
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**修改一个用户数据*/
    @Test
    public void test3(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(5, "4号", "12345");
            int i = userMapper.updateUser(user);
            if(i>0){
                System.out.println("修改成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**删除数据*/
    @Test
    public void test4(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int i = userMapper.deleteUser(5);
            if(i>0){
                System.out.println("删除成功！");
            }
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**map查询，Map是一个键值对*/
    @Test
    public void test6(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("ids",1);//此处的值和xml中对应
            User user = userMapper.getUserById2(map);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**模糊查询-两种方式，其中一种可以预防sql注入*/
    @Test
    public void test7(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserLike("%1%");
            /**SQL注入测试
            List<User> userList = userMapper.getUserLike("1");*/
            System.out.println();
            for(User user : userList){
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**测试log4j：其中：info、debug和error为日志级别*/
    @Test
    public void testLog4j(){
        /*getLogger中传入使用当前Log4j的class对象*/
        /*相当于System.out.println();*/
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    /**使用limit实现分页*/
    @Test
    public void testLimit(){
        SqlSession sqlSession = null;
        try{
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            HashMap map = new HashMap<String,Integer>();
            map.put("startNum",0);
            map.put("Size",2);
            List<User> userList = userMapper.getUserByLimit(map);
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){

        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    /**RowBounds实现分页*/
    @Test
    public void testRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*RowBounds实现*/
        RowBounds rowBounds = new RowBounds(1, 2);
        /*通过java代码层面实现分页*/
        List<User> userList = sqlSession.selectList("com.wq.Dao.UserDao.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**使用注解写SQL语句*
     * 注解的本质是反射机制实现，底层是动态代理。客户端不知道底层实现，只访问接口；底层由代理对象帮助客户进行接口和真实对象的访问，
     * 从而完成目标的功能，此即动态代理。
     */
    @Test
    public void tests(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        System.out.println(user);
        sqlSession.close();
    }

    /**注解版查询全部用户*/
    @Test
    public void testNote1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*底层主要应用反射*/
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**注解版根据id和name进行查询*/
    @Test
    public void testNote2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*底层主要应用反射*/
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    /**注解版添加用户*/
    @Test
    public void testNote3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*底层主要应用反射*/
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5,"5号","123456");
        int i = userMapper.addUser(user);
        System.out.println(i);
    }

    /**注解版修改用户*/
    @Test
    public void testNote4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*底层主要应用反射*/
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5,"4号","123456");
        int i = userMapper.updateUser(user);
        System.out.println(i);
    }

    /**注解版删除用户*/
    @Test
    public void testNote5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        /*底层主要应用反射*/
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(5);
        System.out.println(i);
    }

}

