package BasicSQL;

import ActiveSQL.dao.BlogMapper;
import ActiveSQL.pojo.Blog;
import ActiveSQL.utils.IDutils;
import BasicSQL.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * @author 王琪
 * @date 2020/9/30 10:27
 */
public class BlogTest {
    /**插入数据*/
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis学习");
        blog.setAuthor("xxx");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.insertBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java学习");
        mapper.insertBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring学习");
        mapper.insertBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务学习");
        mapper.insertBlog(blog);

        sqlSession.close();
    }

    /**查询博客
     * 该方法内部使用if（Mapper中）*/
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        /*这条语句提供了可选的查找文本功能。如果不传入 “title”，那么所有处于
         “ACTIVE” 状态的 BLOG 都会返回；如果传入了 “title” 参数，那么就会对
         “title” 一列进行模糊查找并返回对应的 BLOG 结果*/
        HashMap map = new HashMap();
        //map.put("title","Mybatis学习");
        map.put("author","xxx");
        List<Blog> blogList = mapper.queryBlogIF1(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    /**使用choose 元素的查询*/
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","xxx");
        map.put("views",9999);
        List<Blog> blogList = mapper.queryBlogChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    /**动态更新语句，set*/
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Mybatis");
        map.put("author","xxx");
        map.put("id","e30faefd1afb45f0bf4f2a881fbd04ff");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        List<Blog> list = mapper.queryBlogForeach(map);
        for (Blog blog : list) {
            System.out.println(blog);
        }
        sqlSession.close();
    }


}
