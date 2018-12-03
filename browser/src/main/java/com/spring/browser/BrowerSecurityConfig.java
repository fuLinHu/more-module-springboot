package com.spring.browser;

import com.spring.core.properties.SecurityConstants;
//import com.spring.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Autowired
    private SecurityProperties securityProperties;*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //log.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        //设置登录,注销，表单登录不用拦截，其他请求要拦截
        http.formLogin()
                //.loginPage("/imooc-signIn.html")//自定义的登录页面
                .loginPage("/authentication/require") //跳转到一个controller层，然后在那里面进行控制跳转
                .loginProcessingUrl("/authentication/form") //可以任意写，不用实现，但必须和登录表单post、请求action对应
                .and()
                .authorizeRequests()
                .antMatchers("/user/test",SecurityConstants.DEFAULT_UNAUTHENTICATION_URL/*,securityProperties.getBrowser().getLoginPage()*/).permitAll() //指明哪些路径可以通过
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();//取消csrf攻击的防护

       /* http.authorizeRequests().antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin();
        //关闭默认的csrf认证
        http.csrf().disable();*/

    }
}
