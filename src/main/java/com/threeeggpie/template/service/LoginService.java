package com.threeeggpie.template.service;


import com.threeeggpie.template.pojo.entity.User;

public interface LoginService {

    String login(User user);

    boolean updatePassword(String password);
}
