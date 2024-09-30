package com.example.demo.mapper;

import com.example.demo.model.User;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 插入用户
    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    void insert(User user);

    // 根据用户名查找用户
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findByUserId(String id);
}
