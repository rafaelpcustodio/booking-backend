//package com.booking.interfaces.adapter.http.security.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//
//@Configuration
//@EnableWebSecurity
//public class BasicConfiguration extends WebSecurityConfigurerAdapter {
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    PasswordEncoder encoder =
//        PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    auth
//        .inMemoryAuthentication()
//        .withUser("user")
//        .password(encoder.encode("password"))
//        .roles("USER")
//        .and()
//        .withUser("admin")
//        .password(encoder.encode("admin"))
//        .roles("USER", "ADMIN");
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//        .authorizeRequests()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
//  }
//}
