package org.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

public interface UserMapper {

    @Select("select ")
    User findUserByName(String username);

    void add(String username, String encryptPassword);
}
