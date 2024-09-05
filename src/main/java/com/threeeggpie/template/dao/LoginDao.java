package com.threeeggpie.template.dao;


import com.threeeggpie.template.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginDao {
    @Select("SELECT username, password, type FROM users WHERE username = #{username} and password=#{password} and type = #{type}")
    User findByUserName(@Param("username") String username, @Param("password") String password, @Param("type") int type);

    @Update("update users set users=#{password} where users='admin' ")
    int updatePassword(String password);
}
