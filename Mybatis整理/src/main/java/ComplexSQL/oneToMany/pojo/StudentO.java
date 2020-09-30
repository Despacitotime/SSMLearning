package ComplexSQL.oneToMany.pojo;
import lombok.Data;
/**
 * @author xxx
 * @date 2020/9/29 15:26
 */
@Data
public class StudentO {
    private int id;
    private String name;
    /**学生需要关联一个老师，此处使用关联来写*/
    private int tid;
}

