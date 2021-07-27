package com.gg.mlg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetails;
    @Autowired private CustomOAuth2UserService customOauth2UserService;
    @Bean public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/pic/**", "/css/**", "/js/**", "/img/**", "/error", "favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()

                .antMatchers("/getDetail","/getID","/home","/lol","/bg","/board/list","/board/detail","/board/page",
                        "/user/login", "/user/join", "/user/auth").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/login")
                .usernameParameter("uid")
                .passwordParameter("upw")
                .defaultSuccessUrl("/home");

        http.oauth2Login()
                .loginPage("/user/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/board/detail")
                .userInfoEndpoint() //OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.
                .userService(customOauth2UserService);

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login")
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
}
