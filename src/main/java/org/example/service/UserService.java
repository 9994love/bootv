package org.example.service;

import org.example.pojo.User;

public interface UserService {

     User findUserByName(String username);

    void register(String username, String password);
}
