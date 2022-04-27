package com.dao;
import com.entities.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProviderDAO {
    public int regisUser(User user);
    public User getUser(@Param("id") Long id);
    public int updateUser(User user);

    public int signRegister(Register register);
    public Register getRegister(@Param("id") Long id);
//    挂号当日有效，过期无效。换科室、医生只需要重新叫好即可。
}
