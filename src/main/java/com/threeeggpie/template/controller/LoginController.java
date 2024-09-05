package com.threeeggpie.template.controller;


import com.threeeggpie.template.pojo.Result;
import com.threeeggpie.template.pojo.entity.User;
import com.threeeggpie.template.service.LoginService;
import com.threeeggpie.template.util.JwtUtils;
import com.threeeggpie.template.vo.LoginResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>Project: VbenBackApplication - LoginController
 * <p>Powered by echo On 2024-08-24 20:09:44
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Result<LoginResponseVO> login(@RequestBody User user) {
            loginService.login(user);
            LoginResponseVO loginResponseVO = new LoginResponseVO();
            loginResponseVO.setUsername(user.getUsername());
            loginResponseVO.setAccessToken(JwtUtils.getToken(user, 1));
            loginResponseVO.setRefreshToken(JwtUtils.getToken(user, 10));
            loginResponseVO.setExpires(new Date(new Date().getTime() + 10 * 24 * 60 * 60 * 1000L));
            return Result.ok(loginResponseVO);
    }



}
