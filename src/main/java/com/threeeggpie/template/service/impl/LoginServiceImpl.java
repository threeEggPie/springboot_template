package com.threeeggpie.template.service.impl;


import com.threeeggpie.template.dao.LoginDao;
import com.threeeggpie.template.exception.BaseException;
import com.threeeggpie.template.pojo.entity.User;
import com.threeeggpie.template.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;
    @Override
    public String login(User user) {
        User dbUser=loginDao.findByUserName(user.getUsername(),user.getPassword(),user.getType());
        if (dbUser==null){
            throw new BaseException("用户名或密码不存在");
        }
        return dbUser.getPassword();
    }

    @Override
    public boolean updatePassword(String password) {
        return loginDao.updatePassword(password)>0;
    }
}
