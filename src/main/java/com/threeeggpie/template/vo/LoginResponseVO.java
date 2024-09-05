package com.threeeggpie.template.vo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Project: VbenBackApplication - LoginResponseVO
 * <p>Powered by echo On 2024-08-24 20:50:07
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Data
public class LoginResponseVO {
    private String username;
    private String nickname = "admin";
    private String avatar= "";
    private Date expires;
    private String password;
    private String accessToken;
    private String refreshToken;

}
