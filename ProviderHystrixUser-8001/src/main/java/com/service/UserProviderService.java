package com.service;
import com.CommonResult;
import com.entities.User;
import org.apache.ibatis.annotations.Param;

public interface UserProviderService {
    public int regisUser(User user);
    public User getUser(@Param("id") Long id);
    public int updateUser(User user);
}
