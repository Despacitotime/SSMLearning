package ActiveSQL.dao;

import ActiveSQL.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 王琪
 * @date 2020/9/30 9:25
 */
public interface BlogMapper {
    /**插入数据
     * @param blog
     * @return int*/
    int insertBlog(Blog blog);

    /**查询博客
     * 该方法内部使用if（Mapper中）
     * @param map
     * @return List<Blog>*/
    List<Blog> queryBlogIF1(Map map);

    /**查询博客
     * 该方法内部使用where
     * @param map
     * @return List<Blog>*/
    List<Blog> queryBlogIF2(Map map);

    /**不使用所有的条件，只从多个条件中选择一个进行查询
     * 针对这种情况，MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句
     * 策略变为：传入了 “title” 就按 “title” 查找，传入了 “author” 就按 “author” 查找的情形。
     * 若两者都没有传入，就返回标记为 featured 的 BLOG
     * 使用choose 元素的查询
     * @param map
     * @return List<Blog>*/
    List<Blog> queryBlogChoose(Map map);

    /**动态更新语句，set
     * @param map
     * @return int*/
    int updateBlog(Map map);

    /**通过自定义 trim 元素来定制 where 元素的功能
     * */

    /**查询第1-2-3号集合
     * @param map
     * @return List<Blog>*/
    List<Blog> queryBlogForeach(Map map);
}
