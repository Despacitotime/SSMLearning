package ComplexSQL.com.wq.severalForOne.dao;

import ComplexSQL.com.wq.severalForOne.pojo.StudentS;
import ComplexSQL.com.wq.severalForOne.pojo.TeacherS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王琪
 * @date 2020/9/29 15:00
 */
public interface TeacherMapperS {
    /**根据ID查询老师
     * @param id
     * @return Teacher*/
    @Select("select * from teacher where id=#{id}")
    TeacherS getTeacher(@Param("id") int id);

    /**多对一查询——按照查询嵌套处理
     * 在resultMap里面讲所有的老师对应好，老师对应需要一个子查询*/
    /**查询所有的学生信息，以及对应的老师的信息
     * @return List<Student>*/
    List<StudentS> getStudent1();

    /**多对一查询——按照结果嵌套处理
     * 相当于SQL中的联表查询，没有嵌套查询，只是处理了映射。
     * @return List<Student>*/
    List<StudentS> getStudent2();


}
