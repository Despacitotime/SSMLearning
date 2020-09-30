package ActiveSQL.utils;
import org.junit.jupiter.api.Test;
import java.util.UUID;
/**
 * @author 王琪
 * @date 2020/9/30 9:44
 */

/**抑制警告，将拼写报错隔离掉（有时候为了便利命名拼写并不正确但不是Bug的情况）
 * 工具类 IDutils用于获取随机ID*/
@SuppressWarnings("all")
public class IDutils {
    /*通过该方法获取随机的ID*/
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getId());
    }
}
