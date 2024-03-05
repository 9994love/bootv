package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.form.UpdateAvatarForm;
import org.example.form.UpdateUserForm;
import org.example.pojo.User;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findUserByName(String username);

    @Insert("insert into user(username, password, create_time, update_time)" +
            " value(#{username}, #{encryptPassword}, now(), now())")
    void add(String username, String encryptPassword);

    @Update("update user set nickname=#{nickName}, email=#{email}, update_time=#{updateTime}" +
            "where id = #{id}")
    void updateUser(UpdateUserForm updateUserForm);

    @Update("update user set user_pic=#{avatarUrl}" +
            "where id = #{id}")
    void updateUserAvatar(UpdateAvatarForm form);

    @Update("update user set password=#{newPwd}" +
            "where id = #{id}")
    void updateUserPwd(Integer id, String newPwd);
}
