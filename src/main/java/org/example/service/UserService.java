package org.example.service;

import org.example.exp.BusinessException;
import org.example.form.LoginForm;
import org.example.pojo.User;

public interface UserService {

     User findUserByName(String username);

    void register(String username, String password) throws BusinessException;

    String login(LoginForm loginForm);
}
