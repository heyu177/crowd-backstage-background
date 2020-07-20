import com.atguigu.crowd.util.CrowdUtil;
import org.junit.Test;

public class UtilTest {

    @Test
    public void testCrowdUtil(){
        String password = CrowdUtil.md5("123456");
        System.out.println("密码："+password);
    }
}
