package com.threeeggpie.template.config;

import com.threeeggpie.template.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/login");

    }

    /**
     * 解决跨域问题
     * 跨域问题是指当浏览器中的网页向另一个域名（不同的协议、主机或端口）发起请求时，出于安全考虑，浏览器会限制这种操作。
     *
     * 跨域过程：
     * 具体过程如下：
     *
     * 浏览器发送请求：当你在浏览器中发起跨域请求（比如通过XMLHttpRequest或fetch），浏览器会将请求发送到目标服务器。
     *
     * 服务器响应：目标服务器接收到请求后，会根据请求内容生成响应。如果服务器允许跨域访问，它会在响应中添加CORS相关的响应头（例如Access-Control-Allow-Origin）来表明它接受该跨域请求。
     *
     * 浏览器检查响应：浏览器收到服务器的响应后，会检查响应头是否包含允许跨域的CORS头。如果响应头允许该跨域请求（例如Access-Control-Allow-Origin头中的值与请求的源相匹配），那么浏览器会正常处理这个响应。
     *
     * 浏览器拦截响应：如果服务器没有提供正确的CORS头，浏览器会拦截这个响应，并在控制台中抛出跨域错误。这意味着请求确实到了服务器，服务器也返回了数据，但浏览器不会让你访问这些数据。
     *
     * 非简单请求，会先发送OPTIONS预检请求，确认允许跨域之后再发送真实请求
     *
     * @param registry
     */

    //https://blog.csdn.net/Joker_ZJN/article/details/125790538 通过postman测试后端是否支持跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //对所有路径生效
                .allowedOrigins("") // 允许所有源地址 可以指定
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*"); // 允许的请求头
    }

}
