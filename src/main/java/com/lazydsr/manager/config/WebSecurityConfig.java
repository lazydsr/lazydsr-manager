package com.lazydsr.manager.config;

import com.lazydsr.manager.config.security.CustomUserService;
import com.lazydsr.manager.config.security.MyPasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SecurityConfig
 * PROJECT_NAME: lazy-web
 * PACKAGE_NAME: com.lazy.web.config
 * Created by Lazy on 2017/9/25 22:38
 * Version: 0.1
 * Info: @TODO:...
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //AOP
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService customUserService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
        return new MyPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.error("SecurityConfig start");
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                //.antMatchers("/static/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error")
                //.usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/").successHandler(loginSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .logoutSuccessHandler(logoutSuccessHandler())
                .permitAll();

        super.configure(http);
        http.csrf().disable();
        log.error("SecurityConfig start success");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
        auth.userDetailsService(customUserService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        web.ignoring().antMatchers("/static/**", "/druid/**");

    }

    /**
     * 登录失败处理器
     */
    private LogoutSuccessHandler logoutSuccessHandler() {
        //return new LoginSuccessHandler();
        return new HttpStatusReturningLogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
                User userDetails = (User) authentication.getPrincipal();
                System.out.println("用户退出：username=" + userDetails.getUsername() + ", uri=" + request.getContextPath());
                super.onLogoutSuccess(request, response, authentication);
            }
        };
    }

    /**
     * 登录成功处理器
     */
    private AuthenticationSuccessHandler loginSuccessHandler() {
        //return new LoginSuccessHandler();
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
                User userDetails = (User) authentication.getPrincipal();
                System.out.println("登录用户：username=" + userDetails.getUsername() + ", uri=" + request.getContextPath());
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

}
