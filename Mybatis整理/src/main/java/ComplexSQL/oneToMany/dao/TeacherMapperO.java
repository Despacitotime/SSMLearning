package ComplexSQL.oneToMany.dao;

import ComplexSQL.oneToMany.pojo.StudentO;
import ComplexSQL.oneToMany.pojo.TeacherO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王琪
 * @date 2020/9/29 15:00
 */
public interface TeacherMapperO {
    /**获取所有的老师
     * @return List<Teacher>*/
    List<TeacherO> getTeacherO();

    /**一对多——按结果嵌套查询*/
    /**获取指定老师下的所有学生及老师信息
     * @param id
     * @return Teacher*/
    TeacherO getTeacherO1(@Param("tid") int id);

    /**一对多——按照查询嵌套处理*/
    /**获取指定老师下的所有学生及老师信息
     * @param id
     * @return Teacher*/
    TeacherO getTeacherO2(@Param("tid") int id);

    /**获得学生数据
     * @param id
     * @return StudentS*/
    StudentO getStudentO(@Param("tid") int id);
}
