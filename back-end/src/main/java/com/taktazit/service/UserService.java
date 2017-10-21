package com.taktazit.service;

import com.taktazit.domainobject.User;

/**
 * Created by saeed on 10/21/2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
