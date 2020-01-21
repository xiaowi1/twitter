package com.example.twitter.configuration;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public SecurityConfig(PasswordEncoder passwordEncoder,  DataSource dataSource) {
        super();
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }

    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/index", "/users", "/adduser")
                    .hasAnyAuthority("ROLE_USER")
                    .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login-process")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/index")
                .and()
                .logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("test"))
                .roles("USER");

        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.name, u.password, 1 from user u where u.name=?")
                .authoritiesByUsernameQuery("SELECT u.name, 'ROLE_USER', 1 from user u where u.name=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

}
