package org.example.service;

import org.example.exp.BusinessException;
import org.example.pojo.form.LoginForm;
import org.example.pojo.form.UpdateAvatarForm;
import org.example.pojo.form.UpdatePwdFrom;
import org.example.pojo.form.UpdateUserForm;
import org.example.pojo.entity.User;

public interface UserService {

     User findUserByName(String username);

    void register(String username, String password) throws BusinessException;

    String login(LoginForm loginForm);

    User userInfo();

    void update(UpdateUserForm updateUserForm);

    void updateAvatar(UpdateAvatarForm form);

    void updatePwd(UpdatePwdFrom form);
}
