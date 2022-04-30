package com.dao;
import com.entities.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProviderDAO {
    public int regisUser(User user);
    public User getUser(@Param("id") Long id);
    public int updateUser(User user);
}
