package com.aiit.mapper;

import com.aiit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId=#{userId}")
    public List<User> SelectUser(String userId);
}
