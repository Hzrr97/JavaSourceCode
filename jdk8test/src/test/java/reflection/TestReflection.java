package reflection;

import org.hzr.modules.generic.entity.User;
import org.junit.jupiter.api.Test;

public class TestReflection {

    @Test
    public void classTest() throws Exception {
        // 获取Class对象的三种方式
        System.out.println("根据类名:" + User.class);
        System.out.println("根据对象:" + new User().getClass());
        System.out.println("根据全限定类名:" + Class.forName("org.hzr.modules.generic.entity.User"));

        // 常用的方法
        Class<User> userClass = User.class;
        System.out.println("获取全限定类名:" + userClass.getName());
        System.out.println("获取类名:" + userClass.getSimpleName());
        System.out.println("实例化:" + userClass.newInstance());
    }
}
