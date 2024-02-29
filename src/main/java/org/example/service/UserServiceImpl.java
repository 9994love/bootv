package org.example.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.constants.ExceptionEnum;
import org.example.exp.BusinessException;
import org.example.form.LoginForm;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.util.JwtUtil;
import org.example.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public void register(String username, String password) throws BusinessException{
        User user = findUserByName(username);
        if (null != user) {
            throw new BusinessException(ExceptionEnum.USER_ALREADY_EXISTS.getCode(), ExceptionEnum.USER_ALREADY_EXISTS.getName());
        }else {
            String encryptPassword = Md5Util.getMD5String(password);
            userMapper.add(username, encryptPassword);
        }
    }

    @Override
    public String login(LoginForm loginForm) {
        User userInDB = userMapper.findUserByName(loginForm.getUsername());
        if (null == userInDB) {
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
        if (!StringUtils.equals(Md5Util.getMD5String(loginForm.getPassword()), userInDB.getPassword())) {
            throw new BusinessException(ExceptionEnum.WRONG_PASSWORD);
        }

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("username", userInDB.getUsername());
        claims.put("password", userInDB.getPassword());
        return JwtUtil.genToken(claims);
    }
}
