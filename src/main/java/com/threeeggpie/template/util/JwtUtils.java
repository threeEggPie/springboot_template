package com.threeeggpie.template.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.threeeggpie.template.pojo.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>Project: VbenBackApplication - JwtUtils
 * <p>Powered by echo On 2024-08-25 12:12:20
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Slf4j
public class JwtUtils {
    private static final String SECRET = "token!Q@W#E$R";

    /**
     * 生产token
     */
    public static String getToken(User user, Integer days) {
        JWTCreator.Builder builder = JWT.create(); //创建一个 JWT 的构建器对象
        // payload   将用户信息放到令牌里面
        user.toMap().forEach(builder::withClaim); //将用户信息作为声明（Claim）添加到 JWT 的 Payload（负载）部分
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, days);//将日期向前推进指定的天数

        builder.withExpiresAt(instance.getTime());// 指定令牌的过期时间
        return builder.sign(Algorithm.HMAC256(SECRET));//使用 HMAC256 算法签署 JWT
    }

    public static User parseToken(String token) {
        // 解析
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        // 获取指定值
        String username = verify.getClaim(User.USERNAME).asString();
        String password = verify.getClaim(User.PASSWORD).asString();
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }


    /**
     * 验证token
     */
    public static void verify(String token) {
        // 如果有任何验证异常，此处都会抛出异常
        log.info("verify token {}", token);
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        if (verify.getExpiresAt().before(new Date())) {
            throw new TokenExpiredException("token 过期了");
        }
    }

}
