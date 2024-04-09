package proxy;

import org.hzr.modules.proxy.UserLogCglibProxy;
import org.hzr.modules.proxy.UserLogJdkProxy;
import org.hzr.modules.proxy.service.IUserService;
import org.hzr.modules.proxy.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class TestJdkProxy {

    @Test
    public void Test(){
        // proxy
        IUserService userService = new UserLogJdkProxy(new UserServiceImpl()).getLoggingProxy();

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
