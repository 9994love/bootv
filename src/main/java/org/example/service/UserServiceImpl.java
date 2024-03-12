package org.example.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.constants.ExceptionEnum;
import org.example.exp.BusinessException;
import org.example.pojo.form.LoginForm;
import org.example.pojo.form.UpdateAvatarForm;
import org.example.pojo.form.UpdatePwdFrom;
import org.example.pojo.form.UpdateUserForm;
import org.example.mapper.UserMapper;
import org.example.pojo.entity.User;
import org.example.util.JwtUtil;
import org.example.util.Md5Util;
import org.example.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
        claims.put("id", userInDB.getId());
        return JwtUtil.genToken(claims);
    }

    @Override
    public User userInfo() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        return userMapper.findUserByName(username);
    }

    @Override
    public void update(UpdateUserForm updateUserForm) {
        updateUserForm.setId(ThreadLocalUtil.getIdFromThreadLocal());
        updateUserForm.setUpdateTime(LocalDateTime.now());
        userMapper.updateUser(updateUserForm);
    }

    @Override
    public void updateAvatar(UpdateAvatarForm form) {
        form.setId(ThreadLocalUtil.getIdFromThreadLocal());
        form.setUpdateTime(LocalDateTime.now());
        userMapper.updateUserAvatar(form);
    }

    @Override
    public void updatePwd(UpdatePwdFrom form) {
        //因为数据库的密码是加密后的，所以都需要加密
        String userName = ThreadLocalUtil.getUserNameFromThreadLocal();
        User user = userMapper.findUserByName(userName);
        String password = user.getPassword();
        Integer id = user.getId();
        String oldPwd = Md5Util.getMD5String(form.getOld_pwd());
        String newPwd = Md5Util.getMD5String(form.getNew_pwd());
        String rePwd = Md5Util.getMD5String(form.getRe_pwd());
        if (!StringUtils.equals(password, oldPwd)) {
            throw new BusinessException(ExceptionEnum.WRONG_PASSWORD);
        }
        if (!StringUtils.equals(newPwd, rePwd)) {
            throw new BusinessException(ExceptionEnum.NOT_SAME_PASSWORD);
        }
        userMapper.updateUserPwd(id, newPwd);
    }


}
