package com.threeeggpie.template.interceptor;


import com.auth0.jwt.exceptions.TokenExpiredException;
import com.threeeggpie.template.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>Project: VbenBackApplication - LoginInterceptor
 * <p>Powered by echo On 2024-08-25 12:31:47
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("authorized-token");
        log.info("authorization is {}", authorization);
        // 判断是否过期
        if (authorization == null || !authorization.startsWith("Bearer "))
            throw new TokenExpiredException("token不存在");
        log.info("current request uri is {}", request.getRequestURI());
        authorization = authorization.substring(7);
        JwtUtils.verify(authorization);
        return true;
    }
}
