package com.it.config;

import com.it.filter.JwtVerifyFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true) // 开启方法级的动态授权
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private RsaKeyProperties prop;

    // 配置springSecurity相关信息
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 释放静态资源，指定资源拦截规则，指定自定义认证页面，指定退出认证配置，csrf配置
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtVerifyFilter(super.authenticationManager(), prop))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 分布式中原有的session管理机制已经没用了，所以可以禁掉
                ;

    }
}
