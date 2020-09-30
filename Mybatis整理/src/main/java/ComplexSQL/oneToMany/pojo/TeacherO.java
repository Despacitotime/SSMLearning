package ComplexSQL.oneToMany.pojo;
import lombok.Data;
import java.util.List;
/**
 * @author 王琪
 * @date 2020/9/29 15:26
 */

@Data
public class TeacherO {
    private int id;
    private String name;
    /**一个老师拥有多个学生*/
    private List<StudentO> students;
}
