package org.hzr.modules.proxy.service;

import org.hzr.modules.proxy.entity.User;

import java.util.Collections;
import java.util.List;


/**
 * @author pdai
 */
public class UserServiceImpl implements IUserService {

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("pdai", 18));
    }

    /**
     * add user
     */
    public void addUser() {
        // do something
    }

}
