package BasicSQL.com.wq;
import BasicSQL.com.wq.utils.MybatisUtils;
import ComplexSQL.com.wq.oneToMany.dao.TeacherMapperO;
import ComplexSQL.com.wq.oneToMany.pojo.TeacherO;
import ComplexSQL.com.wq.severalForOne.dao.TeacherMapperS;
import ComplexSQL.com.wq.severalForOne.pojo.TeacherS;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author xxx
 * @date 2020/9/29 15:04
 */
public class ComplexTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapperO mapper = sqlSession.getMapper(TeacherMapperO.class);
        TeacherO teacher = mapper.getTeacherO1(1);
        System.out.println(teacher);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapperS mapper = sqlSession.getMapper(TeacherMapperS.class);
        TeacherS teacher = mapper.getTeacherS(1);
        System.out.println(teacher);
        sqlSession.close();
    }


}
