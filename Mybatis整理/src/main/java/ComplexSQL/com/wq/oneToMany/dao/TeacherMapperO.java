package ComplexSQL.com.wq.oneToMany.dao;

import ComplexSQL.com.wq.oneToMany.pojo.TeacherO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王琪
 * @date 2020/9/29 15:00
 */
public interface TeacherMapperO {
    /**获取所有的老师
     * @return List<Teacher>*/
    List<TeacherO> getTeacher();

    /**一对多——按结果嵌套查询*/
    /**获取指定老师下的所有学生及老师信息
     * @param id
     * @return Teacher*/
    TeacherO getTeacher1(@Param("tid") int id);

    /**一对多——按照查询嵌套处理*/
    /**获取指定老师下的所有学生及老师信息
     * @param id
     * @return Teacher*/
    TeacherO getTeacher2(@Param("tid") int id);
}
