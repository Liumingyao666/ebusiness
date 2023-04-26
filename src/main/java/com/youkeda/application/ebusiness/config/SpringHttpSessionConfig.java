package com.youkeda.application.ebusiness.config;

import org.redisson.spring.session.config.EnableRedissonHttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author 刘铭垚
 * @version 1.0
 */
@Configuration
@EnableRedissonHttpSession(maxInactiveIntervalInSeconds = 100)
public class SpringHttpSessionConfig {
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID");
        // 用正则表达式配置匹配的域名，可以兼容 localhost、127.0.0.1 等各种场景
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        serializer.setCookiePath("/");
        serializer.setUseHttpOnlyCookie(false);
        // 最大生命周期的单位是秒
        serializer.setCookieMaxAge(24 * 60 * 60);
        return serializer;
    }
}
