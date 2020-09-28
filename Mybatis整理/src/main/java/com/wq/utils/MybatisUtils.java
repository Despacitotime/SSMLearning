package com.wq.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 王琪
 * @date 2020/9/29 0:02
 */
public class MybatisUtils {
    /**SqlSessionFactory是MyBatis的关键对象,是单个数据库映射关系经过编译后的内存镜像。
     * 其对象由SqlSessionFactoryBuilder对象类获得，SqlSessionFactoryBuilder则可从XML配置文件或者一个预先定制的Configuration的
     * 实例构建出，即对应我们的mybatis-config.xml文件中的配置。每一个MyBatis的应用程序都以一个SqlSessionFactory对象的实例为核心
     * SqlSessionFactory线程安全，一旦被创建，则在应用执行期间都存在，建议在应用运行期间不要重复创建多次（此处可用工具类来定义，观察
     * 可发现，在工具类中它相当于单例模式的那个单例），SqlSessionFactory是创建SqlSession的工厂*/
    private static SqlSessionFactory sqlSessionFactory;
    /**静态代码块，只要创建该类的实例必然会运行该部分*/
    static {
        try {
            /**获取 SqlSessionFactory 的实例*/
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**既有 SqlSessionFactory，则可从中获得 SqlSession 的实例。
     * SqlSession 提供了在数据库执行 SQL 命令所需的所有方法，可通过 SqlSession 实例来直接执行已映射的 SQL 语句。*/
    public static SqlSession getSqlSession(){
        /*设置为true的好处是会自动进行提交，而不用手动进行事务的提交*/
        return sqlSessionFactory.openSession(true);
    }
}
