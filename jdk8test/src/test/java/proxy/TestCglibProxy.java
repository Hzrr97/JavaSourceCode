package proxy;

import org.hzr.modules.proxy.UserLogCglibProxy;
import org.hzr.modules.proxy.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class TestCglibProxy {

    @Test
    public void Test(){
        // proxy
        UserServiceImpl userService = (UserServiceImpl) new UserLogCglibProxy().getUserLogProxy(new UserServiceImpl());

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
