package ComplexSQL.severalForOne.pojo;
import lombok.Data;

/**
 * @author 94105
 */
@Data
public class StudentS {
    private int id;
    private String name;
    //学生需要关联一个老师，此处应该使用关联来写
    private TeacherS teacher;
}

