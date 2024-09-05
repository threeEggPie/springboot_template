package com.threeeggpie.template.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: VbenBackApplication - User
 * <p>Powered by echo On 2024-08-25 12:21:06
 *
 * @author sofency [sofency@qq.com]
 * @version 1.0
 * @since 17
 */
@Data
@AllArgsConstructor
@Builder
public class User {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String TYPE = "type";
    private String username;
    private String password;
    private int type;

    public Map<String, String> toMap() {
        Map<String, String> result = new HashMap<>();
        result.put(USERNAME, this.username);
        result.put(PASSWORD, this.password);
        result.put(TYPE, String.valueOf(this.type));
        return result;
    }
}
