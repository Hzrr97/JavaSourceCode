package org.hzr.modules.proxy.service;

import org.hzr.modules.proxy.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * find user list.
     *
     * @return user list
     */
    List<User> findUserList();

    /**
     * add user
     */
    void addUser();
}
