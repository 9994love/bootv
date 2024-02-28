package org.example.service;

import org.example.constants.ExceptionEnum;
import org.example.exp.BusinessException;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public void register(String username, String password) {
        User user = findUserByName(username);
        if (null != user) {
            throw new BusinessException(ExceptionEnum.USER_ALREADY_EXISTS.getCode(), ExceptionEnum.USER_ALREADY_EXISTS.getName());
        }else {
            String encryptPassword = Md5Util.getMD5String(password);
            userMapper.add(username, encryptPassword);
        }
    }
}
