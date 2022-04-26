package com.service;
import com.entities.User;
import org.apache.ibatis.annotations.Param;

public interface ProviderService {
    public int regisUser(User user);
    public User getUser(@Param("id") Long id);
    public int updateUser(User user);
}
