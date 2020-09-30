package ActiveSQL.pojo;
import lombok.Data;
import java.util.Date;
/**
 * @author xxx
 * @date 2020/9/29 18:25
 */

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
